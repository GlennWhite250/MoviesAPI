package com.example.moviesapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var adapter: MovieAdapter
    val finalAdapter : MovieAdapter by lazy {
        MovieAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initNetwork()
    }

    fun initView(){
        recycler_view.layoutManager =
            LinearLayoutManager(this)
        adapter = MovieAdapter()
        recycler_view.adapter = adapter
    }

    fun initNetwork(){
        val retrofit: Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.androidhive.info")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        val movieApi: MovieApi =
            retrofit.create(MovieApi::class.java)
        movieApi.getMeMovies().enqueue(
             object: Callback<List<MovieItems>>{
                 override fun onFailure(call: Call<List<MovieItems>>, t: Throwable) {
                     Toast.makeText(this@MainActivity, "Server is Broken", Toast.LENGTH_SHORT).show()
                 }

                 override fun onResponse(
                     call: Call<List<MovieItems>>,
                     response: Response<List<MovieItems>>
                 ) {
                     if(response.isSuccessful)
                         response.body()?.let {
                            adapter.dataSet = it as MutableList<MovieItems>}
                 }
             }
        )

    }
}