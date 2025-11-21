package com.example.bai05.network

import com.example.bai05.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("categories.php")
    fun getCategories(): Call<List<Category>>
}

