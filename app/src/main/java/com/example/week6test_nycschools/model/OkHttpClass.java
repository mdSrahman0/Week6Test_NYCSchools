package com.example.week6test_nycschools.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClass {

    public void getSchoolNameAsyncResponse() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient returnClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();
        Request request = new Request.Builder().url("https://data.cityofnewyork.us/resource/f9bf-2cp4.json").build();

        returnClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Type list = new TypeToken<List<SATResponse>>(){}.getType();
                //get json response from the rest call
                String info = response.body().string();

                //Create a gson converter for the json string
                Gson gson = new Gson();

                //post an EventBus post event containing the GithubResponse object parsed from the json
                Log.d("TAG", info);

                // must pass "info" to gson.fromJson, not response.body().string() because
                // that's trying to call it again
                List<SATResponse> SATresponse = gson.fromJson(info, list);
                EventBus.getDefault().post(SATresponse);
            }
        });
    }
}
