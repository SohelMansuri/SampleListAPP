package com.sohel.mansuri.samplelistapp.list

import com.sohel.mansuri.samplelistapp.base.BasePresenter
import com.sohel.mansuri.samplelistapp.networking.HeroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroPresenter(view: HeroView, private val heroClient: HeroClient, private var heroes: ArrayList<Hero> = arrayListOf()) : BasePresenter<HeroView>(view) {
    fun getHeroes() {
        if(heroes.isEmpty()) {
            view?.showLoading()
            heroClient.api.getAllHeroes().enqueue(object : Callback<List<Hero>> {
                override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                    view?.showErrorMessage(t)
                }

                override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                    response.body()?.let {
                        heroes.addAll(it)
                    }

                    view?.showHeroes(heroes)
                }
            })
        } else {
            view?.showHeroes(heroes)
        }
    }
}