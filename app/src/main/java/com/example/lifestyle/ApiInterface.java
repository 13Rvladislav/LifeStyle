package com.example.lifestyle;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @POST("/data/2.5/weather")
    Call<Weather> getWeatherInformation(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String appid);
}

