package com.example.dell.m2_product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.m2_product.home.presenter.ListPresenterInter;
import com.example.dell.m2_product.home.view.IListView;

public class MainActivity extends AppCompatActivity implements IListView {

    private ListPresenterInter presenterInter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        presenterInter = new ListPresenterInter(this);
        presenterInter.getModelData();
    }

    @Override
    public void getViewData(String viewData)
    {
        tv.setText(viewData);

    }
}
