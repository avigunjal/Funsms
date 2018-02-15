package com.funsms.Networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AVI on 25-12-2017.
 */

public class ApiClient {
    private static final String BASE_URL = "http://funsms.ialchemist.in/";

    public static Retrofit retrofit=null;

    public static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
