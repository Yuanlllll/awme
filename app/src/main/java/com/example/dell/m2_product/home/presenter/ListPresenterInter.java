package com.example.dell.m2_product.home.presenter;

import com.example.dell.m2_product.MainActivity;
import com.example.dell.m2_product.api.Api;
import com.example.dell.m2_product.home.model.ListModelinter;
import com.example.dell.m2_product.home.model.ModelInter;

public class ListPresenterInter implements PresenterInter,ListModelinter.ModuleInterface {
private MainActivity mview;
private ListModelinter listModelinter;

    public ListPresenterInter(MainActivity mview) {
        this.mview = mview;
       listModelinter= new ListModelinter(this);
    }




    @Override
    public void LoadSuccess(String data)
    {
        mview.getViewData(data);

    }

    @Override
    public void LoadFailed()
    {
        mview.getViewData("加载失败");

    }

    @Override
    public void getModelData()
    {
        listModelinter.getData(Api.SHOPLIST);

    }
}
