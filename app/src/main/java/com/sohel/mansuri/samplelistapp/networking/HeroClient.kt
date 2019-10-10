package com.sohel.mansuri.samplelistapp.networking

object HeroClient {
    val api: HeroService = ConfigSingleton.getRetrofitService().create(HeroService::class.java)
}