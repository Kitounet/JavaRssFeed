package com.example.bbizet.javarssfeed.service;

import com.example.bbizet.javarssfeed.receiver.Flux;
import com.example.bbizet.javarssfeed.receiver.Login;
import com.example.bbizet.javarssfeed.receiver.Register;
import com.example.bbizet.javarssfeed.receiver.SpecificFlux;
import com.example.bbizet.javarssfeed.requestClass.LoginBody;
import com.example.bbizet.javarssfeed.requestClass.SubscribeBody;

import java.util.HashMap;
import java.util.List;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by bbizet on 07/04/2017.
 */

public interface RequestService {

    public static final String ENDPOINT = "http://192.168.1.40:8081/api";

    @Headers("Content-Type: application/json")
    @POST("/auth/signin")
    Observable<Register> subscribe(@Body SubscribeBody body);

    @Headers("Content-Type: application/json")
    @POST("/auth/login")
    Observable<Login> getToken(@Body LoginBody body);

    @Headers("Content-Type: application/json")
    @GET("/feed")
    Observable<Flux>    getFlux(@Header("Authorization") String token);

    @Headers("Content-Type: application/json")
    @GET("/feed/{id}")
    Observable<SpecificFlux> getSpecificFlux(@Path("id") int id, @Header("Authorization") String token);

}
