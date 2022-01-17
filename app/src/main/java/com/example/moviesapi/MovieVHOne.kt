package com.example.moviesapi

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movies_item_layout.view.*
import kotlinx.android.synthetic.main.movies_item_layout2.view.*
import kotlinx.android.synthetic.main.movies_item_layout3.view.*

class MovieVHOne(itemOne: View):
    RecyclerView.ViewHolder(itemOne){

    val ivOne: ImageView = itemOne.iv_view_one
    val tvOneTitle: TextView = itemOne.tv_view_one_title
    val tvOneYear: TextView = itemOne.tv_view_one_year
    val tvOneRating: TextView = itemOne.tv_view_one_rating
    val tvOneGenre: TextView = itemOne.tv_view_one_genre

    fun onBind(movieItem: MovieItems){
        tvOneTitle.text = movieItem.title
        tvOneRating.text = movieItem.rating.toString()
        tvOneYear.text = movieItem.releaseYear.toString()
        tvOneGenre.text = movieItem.genre.joinToString()
        Picasso.get().load(movieItem.image).into(ivOne)
    }
}

class MovieVHTwo(itemTwo: View):
    RecyclerView.ViewHolder(itemTwo){

    val ivTwo: ImageView = itemTwo.iv_view_two
    val tvTwoTitle: TextView = itemTwo.tv_view_two_title
    val tvTwoYear: TextView = itemTwo.tv_view_two_year
    val tvTwoRating: TextView = itemTwo.tv_view_two_rating
    val tvTwoGenre: TextView = itemTwo.tv_view_two_genre

    fun onBind(movieItem: MovieItems){
        tvTwoTitle.text = movieItem.title
        tvTwoRating.text = movieItem.rating.toString()
        tvTwoYear.text = movieItem.releaseYear.toString()
        tvTwoGenre.text = movieItem.genre.joinToString()
        Picasso.get().load(movieItem.image).into(ivTwo)
    }
}

class MovieVHThree(itemThree: View):
    RecyclerView.ViewHolder(itemThree){

    val ivThree: ImageView = itemThree.iv_view_three
    val tvThreeTitle: TextView = itemThree.tv_view_three_title
    val tvThreeYear: TextView = itemThree.tv_view_three_year
    val tvThreeRating: TextView = itemThree.tv_view_three_rating
    val tvThreeGenre: TextView = itemThree.tv_view_three_genre

    fun onBind(movieItem: MovieItems){
        tvThreeTitle.text = movieItem.title
        tvThreeRating.text = movieItem.rating.toString()
        tvThreeYear.text = movieItem.releaseYear.toString()
        tvThreeGenre.text = movieItem.genre.joinToString()
        Picasso.get().load(movieItem.image).into(ivThree)
    }
}