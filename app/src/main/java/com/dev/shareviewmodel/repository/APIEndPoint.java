package com.dev.shareviewmodel.repository;

import com.dev.shareviewmodel.model.RESPONSE.listUser;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndPoint {
    String BASE_URL = "https://reqres.in/api/";
    @GET("users")
    Call<listUser> listuser();
}
