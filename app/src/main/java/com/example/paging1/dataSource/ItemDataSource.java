package com.example.paging1.dataSource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paging1.db.API_Client;
import com.example.paging1.db.model.Items;
import com.example.paging1.db.model.m_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, Items> {
    public static final int FIRST_PAGE = 1;
    public static final int PAGE_SIZE = 50;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        API_Client.getINSTANCE().getStackOverFlowResponse(
                FIRST_PAGE,
                PAGE_SIZE)
                .enqueue(new Callback<m_model>() {
                    @Override
                    public void onResponse(Call<m_model> call, Response<m_model> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), null, FIRST_PAGE + 1);
                        }
                    }

                    @Override
                    public void onFailure(Call<m_model> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        API_Client.getINSTANCE().getStackOverFlowResponse(
                (int) params.key,
                PAGE_SIZE)
                .enqueue(new Callback<m_model>() {
                    @Override
                    public void onResponse(Call<m_model> call, Response<m_model> response) {
                        Integer key = ((int) params.key > 1 ? (int) params.key - 1 : null);
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<m_model> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        API_Client.getINSTANCE().getStackOverFlowResponse(
                (int) params.key,
                PAGE_SIZE)
                .enqueue(new Callback<m_model>() {
                    @Override
                    public void onResponse(Call<m_model> call, Response<m_model> response) {
                        Integer key = response.body().getHas_more() ? (int) params.key + 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body().getItems(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<m_model> call, Throwable t) {

                    }
                });
    }
}
