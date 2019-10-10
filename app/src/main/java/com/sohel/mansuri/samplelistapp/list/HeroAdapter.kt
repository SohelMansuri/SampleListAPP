package com.sohel.mansuri.samplelistapp.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sohel.mansuri.samplelistapp.R
import kotlin.collections.ArrayList

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    private var heroes: ArrayList<Hero> = arrayListOf()

    fun setHeroes(heroes: ArrayList<Hero>) {
        val filteredHeroes = heroes.filter { hero -> !hero.publicIdentity.isNullOrEmpty() }
            .sortedWith(compareBy({ it.listId }, { it.publicIdentity }))
        this.heroes = ArrayList(filteredHeroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bind(heroes[position])
    }

    inner class HeroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val id = itemView.findViewById<TextView>(R.id.hero_item_id)
        private val publicIdentity = itemView.findViewById<TextView>(R.id.hero_item_public_identity)
        private val age = itemView.findViewById<TextView>(R.id.hero_item_age)

        fun bind(hero: Hero) {
            id.text = "ID: ${hero.listId}"
            publicIdentity.text = hero.publicIdentity ?: ""
            age.text = hero.age.toString()
        }
    }
}