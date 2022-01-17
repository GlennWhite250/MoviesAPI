package com.example.moviesapi

import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    //BASE URL = https://api.androidhive.info
    //END POINT = /json/movies.json
    @GET("/json/movies.json")
    fun getMeMovies(): Call<List<MovieItems>>
}