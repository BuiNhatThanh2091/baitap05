package com.example.bai05

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bai05.model.Category
import com.example.bai05.network.APIService
import com.example.bai05.network.RetrofitClient
import com.example.bai05.ui.CategoryAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {

    private lateinit var rcCategory: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        rcCategory = findViewById(R.id.rc_category)
        rcCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        fetchCategories()
    }

    private fun fetchCategories() {
        val service = RetrofitClient.instance.create(APIService::class.java)
        service.getCategories().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                if (response.isSuccessful) {
                    val list = response.body() ?: emptyList()
                    rcCategory.adapter = CategoryAdapter(list)
                } else {
                    Log.d("RetrofitActivity", "Response error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Log.d("RetrofitActivity", "Failure: ${t.message}")
            }
        })
    }
}
