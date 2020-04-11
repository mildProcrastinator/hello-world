package com.INFS3634.ass3;

import com.INFS3634.ass3.Entities.ChuckNorrisResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {
    @GET("jokes/random/")
    Call<ChuckNorrisResponse> getRandomJoke();
}
