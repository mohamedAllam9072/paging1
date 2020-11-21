package com.example.paging1.db;

import com.example.paging1.db.model.m_model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiServices {
    @GET("answers")
    Call<m_model> getStackOverFlowResponse(@Query("page") int page,
                                           @Query("pagesize") int size,
                                           @Query("site") String site);
}