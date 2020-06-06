package com.chana.benapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chana.benapp.api.Api;
import com.chana.benapp.api.ImageParser;
import com.chana.benapp.recyclerview.PostAdapter;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PostItem> listItem = new ArrayList<>();

        RecyclerView rvList = (RecyclerView) findViewById(R.id.rv_list);

        for (int i = 0; i < 30; i++ ){

            String Url = null;
            String Post = null;
            try {
                Url = getAsyncPostItem(i+1)[0];
                Post = getAsyncPostItem(i+1)[1];
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            PostItem item = new PostItem(true,125,"ben",
                    Url,
                    Post);

            listItem.add(i,item);
        }

        PostAdapter adapter = new PostAdapter(this, listItem);
        rvList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        rvList.setAdapter(adapter);
    }

    private String[] getAsyncPostItem(int i) throws ExecutionException, InterruptedException {
        String[] ImgUrl = new ImageParser().execute(Api.getSEARCH(), String.valueOf(i)).get();
        return ImgUrl;
    }
}
