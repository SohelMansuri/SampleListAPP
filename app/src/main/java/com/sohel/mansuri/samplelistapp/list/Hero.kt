package com.sohel.mansuri.samplelistapp.list

import com.google.gson.annotations.SerializedName

data class Hero(val listId: Int? = null,

                @SerializedName("name")
                val publicIdentity: String? = null,

                val age: Int? = null)