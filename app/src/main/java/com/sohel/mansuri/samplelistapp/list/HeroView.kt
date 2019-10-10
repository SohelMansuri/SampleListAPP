package com.sohel.mansuri.samplelistapp.list

import com.sohel.mansuri.samplelistapp.base.BaseView

interface HeroView : BaseView {
    fun showLoading()
    fun showHeroes(heroes: ArrayList<Hero>)
    fun showErrorMessage(error: Throwable)
}