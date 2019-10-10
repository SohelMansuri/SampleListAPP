package com.sohel.mansuri.samplelistapp.base

abstract class BasePresenter<View : BaseView> protected constructor(protected var view: View?) {
    internal fun destroyView() {
        view = null
    }
}