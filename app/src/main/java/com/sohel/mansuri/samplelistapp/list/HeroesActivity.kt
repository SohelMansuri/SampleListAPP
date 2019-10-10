package com.sohel.mansuri.samplelistapp.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.sohel.mansuri.samplelistapp.R
import com.sohel.mansuri.samplelistapp.base.BaseActivity
import com.sohel.mansuri.samplelistapp.networking.HeroClient
import kotlinx.android.synthetic.main.activity_heroes.*

class HeroesActivity : BaseActivity<HeroPresenter>(), HeroView {

    override fun createPresenter(): HeroPresenter {
        return HeroPresenter(this, HeroClient)
    }

    private var heroAdapter: HeroAdapter = HeroAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        recyclerView.adapter = heroAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.getHeroes()
    }

    override fun showLoading() {
        recyclerView.visibility = View.GONE
        loadingView.visibility = View.VISIBLE
    }

    override fun showHeroes(heroes: ArrayList<Hero>) {
        recyclerView.visibility = View.VISIBLE
        loadingView.visibility = View.GONE
        heroAdapter.setHeroes(heroes)
    }

    override fun showErrorMessage(error: Throwable) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
    }
}
