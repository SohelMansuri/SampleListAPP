package com.sohel.mansuri.samplelistapp.networking

import com.sohel.mansuri.samplelistapp.list.Hero
import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit Interface for handling employee related communication with server.
 */
interface HeroService {
    @GET("/bins/avioq")
    fun getAllHeroes(): Call<List<Hero>>
}