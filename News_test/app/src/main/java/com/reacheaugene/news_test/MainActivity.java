package com.reacheaugene.news_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<newsgt> availnews=new ArrayList<newsgt>();
    List<String> h=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue que=Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest myReq=new JsonObjectRequest(Request.Method.GET, "https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=latest&apiKey=d4f63c57afa3478b9c3fc16b117012c6",
                null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsIte = response.getJSONArray("articles");
                            Log.i("tes","SUccess");
                            for (int i = 0; i < newsIte.length(); i++) {
                                JSONObject temp = newsIte.getJSONObject(i);
                                String title=temp.getString("title");
                                Log.i("tes",title.toString());
                                h.add(i,title.toString());
                                String description=temp.getString("description");
                                String url=temp.getString("url");
                                String img=temp.getString("urlToImage");
                                availnews.add(new newsgt(title.toString(),img.toString(),description.toString(),url.toString()));
                            }
                            ArrayAdapter<newsgt> adapter=new customAdatpter();
                            ListView myFirst=(ListView)(findViewById(R.id.myFirstListView));
                            myFirst.setAdapter(adapter);
                            myFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    newsgt currentnews=availnews.get(position);
                                    String hi=currentnews.getInews();
                                    String ul=currentnews.getUrl();
                                    String igid=currentnews.getImageID();
                                    String des=currentnews.getDesc();
                                    //Toast.makeText(MainActivity.this,hi,Toast.LENGTH_SHORT).show();
                                    Intent newActivity0 = new Intent(MainActivity.this, web.class);
                                    newActivity0.putExtra("title",hi.toString());
                                    newActivity0.putExtra("url",ul.toString());
                                    newActivity0.putExtra("img",igid.toString());
                                    newActivity0.putExtra("descp",des.toString());
                                    Log.i("test","goes");
                                    startActivity(newActivity0);
                                    Log.i("test","goes1");
                                }
                            });
                        }
                        catch (JSONException e){
                            Log.i("test",e.toString());
                            Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("test",error.toString());
                Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();


            }
        });
        myReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        que.add(myReq);

        JsonObjectRequest mReq=new JsonObjectRequest(Request.Method.GET, "https://newsapi.org/v1/articles?source=the-hindu&sortBy=latest&apiKey=d4f63c57afa3478b9c3fc16b117012c6",
                null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsIte = response.getJSONArray("articles");
                            Log.i("tes","SUccess");
                            for (int i = 0; i < newsIte.length(); i++) {
                                JSONObject temp = newsIte.getJSONObject(i);
                                String title=temp.getString("title");
                                Log.i("tes",title.toString());
                                h.add(i,title.toString());
                                String description=temp.getString("description");
                                String url=temp.getString("url");
                                String img=temp.getString("urlToImage");
                                availnews.add(new newsgt(title.toString(),img.toString(),description.toString(),url.toString()));
                            }
                            ArrayAdapter<newsgt> adapter=new customAdatpter();
                            ListView myFirst=(ListView)(findViewById(R.id.myFirstListView));
                            myFirst.setAdapter(adapter);
                            myFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    newsgt currentnews=availnews.get(position);
                                    String hi=currentnews.getInews();
                                    String ul=currentnews.getUrl();
                                    String igid=currentnews.getImageID();
                                    String des=currentnews.getDesc();
                                    //Toast.makeText(MainActivity.this,hi,Toast.LENGTH_SHORT).show();
                                    Intent newActivity0 = new Intent(MainActivity.this, web.class);
                                    newActivity0.putExtra("title",hi.toString());
                                    newActivity0.putExtra("url",ul.toString());
                                    newActivity0.putExtra("img",igid.toString());
                                    newActivity0.putExtra("descp",des.toString());
                                    Log.i("test","goes");
                                    startActivity(newActivity0);
                                    Log.i("test","goes1");
                                }
                            });
                        }
                        catch (JSONException e){
                            Log.i("test",e.toString());
                            //Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("test",error.toString());
                //Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();


            }
        });
        mReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        que.add(mReq);

        JsonObjectRequest nReq=new JsonObjectRequest(Request.Method.GET, "https://newsapi.org/v1/articles?source=techcrunch&sortBy=latest&apiKey=d4f63c57afa3478b9c3fc16b117012c6",
                null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray newsIte = response.getJSONArray("articles");
                            Log.i("tes","SUccess");
                            for (int i = 0; i < newsIte.length(); i++) {
                                JSONObject temp = newsIte.getJSONObject(i);
                                String title=temp.getString("title");
                                Log.i("tes",title.toString());
                                h.add(i,title.toString());
                                String description=temp.getString("description");
                                String url=temp.getString("url");
                                String img=temp.getString("urlToImage");
                                availnews.add(new newsgt(title.toString(),img.toString(),description.toString(),url.toString()));
                            }
                            ArrayAdapter<newsgt> adapter=new customAdatpter();
                            ListView myFirst=(ListView)(findViewById(R.id.myFirstListView));
                            myFirst.setAdapter(adapter);
                            myFirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    newsgt currentnews=availnews.get(position);
                                    String hi=currentnews.getInews();
                                    String ul=currentnews.getUrl();
                                    String igid=currentnews.getImageID();
                                    String des=currentnews.getDesc();
                                    //Toast.makeText(MainActivity.this,hi,Toast.LENGTH_SHORT).show();
                                    Intent newActivity0 = new Intent(MainActivity.this, web.class);
                                    newActivity0.putExtra("title",hi.toString());
                                    newActivity0.putExtra("url",ul.toString());
                                    newActivity0.putExtra("img",igid.toString());
                                    newActivity0.putExtra("descp",des.toString());
                                    Log.i("test","goes");
                                    startActivity(newActivity0);
                                    Log.i("test","goes1");
                                }
                            });
                        }
                        catch (JSONException e){
                            Log.i("test",e.toString());
                            //Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("test",error.toString());
                //Toast.makeText(MainActivity.this,"Check Your Internet Connection!!",Toast.LENGTH_SHORT).show();


            }
        });
        nReq.setRetryPolicy(new DefaultRetryPolicy(
                10000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        que.add(nReq);
	}
    public class customAdatpter extends ArrayAdapter<newsgt>
    {
        public customAdatpter() {
            super(MainActivity.this, R.layout.my_layout,availnews);
        }
        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            if(convertView==null) {
                convertView = getLayoutInflater().inflate(R.layout.my_layout, parent,false);
            }
            newsgt currentnews=availnews.get(position);
            ImageView myimg=(ImageView) convertView.findViewById(R.id.leftIco);
            TextView myheading=(TextView) convertView.findViewById(R.id.heading);
            //TextView mydesc=(TextView) convertView.findViewById(R.id.desc);


            //myimg.setImageResource(R.mipmap.ic_launcher);
            myheading.setText(currentnews.getInews());
            //mydesc.setText(currentnews.getDesc());
            Picasso.with(MainActivity.this).load(currentnews.getImageID()).into(myimg);
            return convertView;
        }
    }
}
