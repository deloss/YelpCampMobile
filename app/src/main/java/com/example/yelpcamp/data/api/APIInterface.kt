package com.example.movieapp.data.api

import io.reactivex.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("campgrounds")
    fun getCampgrounds() : Single<List<Campground>>

}