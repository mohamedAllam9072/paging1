package com.example.paging1.db;


import com.example.paging1.db.model.m_model;

import java.io.IOException;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class API_Client {
    private static final String BASE_URL = "https://api.stackexchange.com/2.2/";
    private static API_Client INSTANCE;
    private ApiServices apiServices;

    public API_Client() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Accept", "application/json").build();
            return chain.proceed(request);
        });
        client.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiServices = retrofit.create(ApiServices.class);
    }

    public static API_Client getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new API_Client();
        }
        return INSTANCE;
    }

    public Call<m_model> getStackOverFlowResponse(int page,int size) {
        return apiServices.getStackOverFlowResponse(page, size,"stackoverflow");
    }

}