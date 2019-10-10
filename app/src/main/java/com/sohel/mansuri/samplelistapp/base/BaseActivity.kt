package com.sohel.mansuri.samplelistapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<Presenter : BasePresenter<*>> : AppCompatActivity() {
    lateinit var presenter: Presenter
    protected abstract fun createPresenter() : Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroyView()
    }
}