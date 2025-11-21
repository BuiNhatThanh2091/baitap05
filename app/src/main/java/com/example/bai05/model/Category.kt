package com.example.bai05.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("images")
    val images: String?,

    @SerializedName("description")
    val description: String?
)

