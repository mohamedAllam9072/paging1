package com.example.paging1.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.paging1.dataSource.DS_Factory.ItemDataSourceFactory;
import com.example.paging1.dataSource.ItemDataSource;
import com.example.paging1.db.model.Items;

public class MainViewModel extends ViewModel {

    private LiveData<PagedList<Items>> itemPagedList;
    private LiveData<PageKeyedDataSource<Integer, Items>> liveDataSource;

    public MainViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE)
                        .build();


        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();

    }
}
