package com.reacheaugene.news_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

import com.squareup.picasso.Picasso;

public class web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Log.i("won","eaugene");
        //Toast.makeText(R.layout.webviewpage, "won", Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        final String title, urly,igi,des;

        if (extras != null) {
            title = extras.getString("title");
            urly = extras.getString("url");
            des=extras.getString("descp");
            Log.i("test",title.toString());
            igi=extras.getString("img");
            ImageView imgl=(ImageView)findViewById(R.id.finimg);
            Picasso.with(web.this).load(igi).into(imgl);
            TextView till=(TextView)findViewById(R.id.fintxt);
            till.setText(title);
            TextView desf=(TextView)findViewById(R.id.findesc);
            desf.setText(des);
            Button imageLogo = (Button)findViewById(R.id.finbtn);
            imageLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = urly;

                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });
            //WebView wbView = (WebView) findViewById(R.id.WebView);
            //wbView.getSettings().setJavaScriptEnabled(true);
            //wbView.loadUrl(url);
        }
    }
}
