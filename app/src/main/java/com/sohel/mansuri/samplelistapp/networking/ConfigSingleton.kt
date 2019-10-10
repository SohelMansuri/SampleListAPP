package com.sohel.mansuri.samplelistapp.networking

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Used to set up the RetrofitService with OkHttpClient to handle timeouts.
 */
object ConfigSingleton {
    private var retrofit: Retrofit? = null
    private const val URL_BASE = "https://api.myjson.com"

    fun getRetrofitService(): Retrofit {
        if (retrofit == null) {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

            val gson = GsonBuilder().setLenient().create()

            retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
        }

        return retrofit!!
    }
}