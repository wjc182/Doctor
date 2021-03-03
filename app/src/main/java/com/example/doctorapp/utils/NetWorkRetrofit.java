package com.example.doctorapp.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkRetrofit {
    //双锁检测
    private static volatile NetWorkRetrofit netWorkRetrofit;
    private final Retrofit retrofit;
    private final Retrofit retrofit1Login;

    //构造
    private NetWorkRetrofit() {
        //拦截器
        OkHttpClient client =  new OkHttpClient
                .Builder()
                .addInterceptor(chain -> {
//                    拦截请求，获取当前请求
                            Log.e("TAG","执行添加请求头操作");
                            Request request = chain.request();
//                          在原请求的基础上，新构建一个请求
                            Request.Builder builder = request.newBuilder();
//                          获取token
                            MMKV mmkv = MMKV.defaultMMKV();
                            String token = mmkv.decodeString("TOKEN","");
//                          通过新构建的请求体，添加请求头
                            builder.addHeader("TOKEN",token);
//                            获得新构建的请求
                            Request build = builder.build();
//                            让当前新构建请求，继续执行请求
                            return chain.proceed(build);
                        }
                )
                .build();

        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URL.baseUrl)
                .client(client)
                .build();


        retrofit1Login = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(URL.loginUrl)
                .client(client)
                .build();

    }
    //单例模式
    public static NetWorkRetrofit getInstance(){
        if(netWorkRetrofit==null){
            synchronized (NetWorkRetrofit.class){
                //创建新的
                netWorkRetrofit=new NetWorkRetrofit();
            }
        }
        return netWorkRetrofit;
    }

    //获取数据方法
    public <T> void iRetrofitPost(String url, RequestBody requestBody, ICallBack<T> iCallBack){

        retrofit.create(ApiServer.class)
                .post(url,requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {


                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        //解析
                        try {
                            String string = responseBody.string();
                            //反射
                            Type[] genericInterfaces = iCallBack.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            iCallBack.onSuccess(json);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG","解析失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //获取数据方法
    public <T> void iRetrofitPostLogin(String url,RequestBody requestBody, ICallBack<T> iCallBack){
        //登陆
        retrofit1Login.create(ApiServer.class)
                .postLogin(url,requestBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {


                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        //解析
                        try {
                            String string = responseBody.string();
                            //反射
                            Type[] genericInterfaces = iCallBack.getClass().getGenericInterfaces();

                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            iCallBack.onSuccess(json);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG","解析失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
