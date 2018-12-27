package com.example.dell.m2_product.home.model;

import com.example.dell.m2_product.network.MyTask;

public class ListModelinter implements ModelInter
{
    ModuleInterface moduleInterface;
    public ListModelinter(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    @Override
    public void getData(final String url)
    {
        new Runnable()
        {
            @Override
            public void run() {
                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        if (t!=null)
                        {
                            moduleInterface.LoadSuccess(t);
                        }
                        else
                        {
                            moduleInterface.LoadFailed();
                        }
                    }
                }).execute();
            }
        }.run();

    }

    public  interface  ModuleInterface
    {
        void LoadSuccess(String data);
        void LoadFailed();

    }
}
