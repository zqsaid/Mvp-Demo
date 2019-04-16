package com.example.zq.mvpdesignpattern.network;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by zq on 2019/4/9.
 *
 * 定义Retrofit具体请求方法
 */

public interface RestService {

    /**
     * GET：向指定的资源发出显示请求（我们一般说的get请求）
     * Url: 请求的URL设置
     * QureyMap: 网络请求参数类型 向Post表单传入键值对，数据体现在请求体上
     */
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);


    /**
     * POST：向指定的资源提交数据，请求服务器进行处理（post请求）
     * FormUrlEncoded: 表示请求体是一个Form表单
     * FieldMap: 网络请求参数 向Post表单传入键值对，数据体现在URL上
     */
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    /**
     * PUT: 向指定资源位置上传其最新内容
     */
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);


    /**
     * DELETE： 请求服务器删除Request-URI所标识的资源
     */
    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);


    /**
     * Streaming: 表示响应体的数据用流的形式返回，一边下载，一边加载内存
     */
    @Streaming
    @GET
    Call<String> download(@Url String url, @QueryMap Map<String, Object> params);


    /**
     * Multipart: 表示请求体是一个支持文件上传的Form表单
     * Part：用于表单字段，适用于有文件上传的情况
     */
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);

}
