package com.sookmyung.r1614223_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@SuppressLint("NewApi")
public class SubActivity extends Activity {
    TextView textview, title;
    Document doc = null;
    RelativeLayout layout = null;
    Intent intent;
    int area;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textview =(TextView) findViewById(R.id.textView1);
        title = (TextView) findViewById(R.id.tv_title);

        GetXMLTask task = new GetXMLTask(this);
        intent = getIntent();
        area = intent.getIntExtra("area",0);

        Log.d("i want sleep!!!!!!!!!!!!!!","yes"+area);

        if(area==1){
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1117053000");
            title.setText("남영동 일기예보");
        } else if(area==2){
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1162069500");
            title.setText("신림동 일기예보");
        } else if(area==3){
            task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135059500");
            title.setText("공릉동 일기예보");
        }
    }

    public void onClick(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
        finish();
    }

    // private inner class extending AsyncTask
    @SuppressLint("NewApi")
    private class GetXMLTask extends AsyncTask<String, Void, Document> {
        private Activity context;

        public GetXMLTask(Activity context) {
            this.context = context;
        }

        @Override
        protected Document doInBackground(String... urls) {

            Handler handler = new Handler(Looper.getMainLooper());
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db;

                db = dbf.newDocumentBuilder();
                doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Parsing Error",
                        Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {
            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);
                Element fstElmnt = (Element) node;
                NodeList timeList = fstElmnt.getElementsByTagName("hour");
                Element timeElement = (Element) timeList.item(0);
                timeList = timeElement.getChildNodes();

                s += ((Node) timeList.item(0)).getNodeValue()+ "시 ";

                NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
                Element websiteElement = (Element) websiteList.item(0);
                websiteList = websiteElement.getChildNodes();
                s += " " + ((Node) websiteList.item(0)).getNodeValue();

                NodeList tempList = fstElmnt.getElementsByTagName("temp");
                Element tempElement = (Element) tempList.item(0);
                tempList = tempElement.getChildNodes();
                s += " " + ((Node) tempList.item(0)).getNodeValue()
                        + "\n";
            }
            textview.setText(s);
        }
    }
}
