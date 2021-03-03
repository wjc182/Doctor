package com.example.doctorapp.utils;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiServer {
    //get
    @GET()
    Observable<ResponseBody> get(@Url String url,@HeaderMap HashMap<String,String> head);
    //post

    @POST()
    Observable<ResponseBody> post(@Url String url, @Body RequestBody requestBody);
    //登陆
    @POST()
    Observable<ResponseBody> postLogin(@Url String url,@Body RequestBody requestBody);




}
