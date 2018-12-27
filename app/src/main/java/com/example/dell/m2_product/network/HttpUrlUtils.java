package com.example.dell.m2_product.network;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlUtils
{
    public static String getHttpCon(String mpath, String Ram)
    {
        String message="";
        try {
            URL murl = new URL(mpath);
            HttpURLConnection connection = (HttpURLConnection) murl.openConnection();
            connection.setRequestMethod(Ram);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            if (connection.getResponseCode()==200)
            {
                InputStream inputStream = connection.getInputStream();
                InputStreamReader streamReader = new InputStreamReader(inputStream,"utf-8");
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder builder = new StringBuilder();
                String str="";
                while ((str=reader.readLine())!=null)
                {
                    builder.append(str);
                }
                message=builder.toString();
                reader.close();
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

}
