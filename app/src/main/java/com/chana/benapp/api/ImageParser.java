package com.chana.benapp.api;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImageParser extends AsyncTask<String, Void, String[]> {

    @Override
    protected String[] doInBackground(String... strings) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = strings[0];
        int index = Integer.decode(strings[1]);
        Request request = new Request.Builder().url(url).build();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements img = doc.select("#_sau_imageTab > " +
                    "div.photowall._photoGridWrapper > div.photo_grid._box > " +
                    "div:nth-child(" + index + ") > a.thumb._thumb > img");
            String imgurl = img.attr("data-source");
            String posttext = img.attr("alt");
            String[] value = new String[2];
            value[0] = imgurl;
            value[1] = posttext;

            return value;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String[] s) {
        super.onPostExecute(s);
        if (s == null)
            Log.d("OnAsyncHttp", "null string");
    }
}

