package com.example.ashvi.endlesslist.api;

import com.example.ashvi.endlesslist.Modal.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Serivce_api {


    @GET("movie/popular")
    Call<MovieResponse> getPopularMovie(@Query("api_key") String apiKey, @Query("page") int pageindex);


    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovie(@Query("api_key") String apiKey, @Query("page") int pageindex);

}
