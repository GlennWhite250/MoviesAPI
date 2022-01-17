package com.example.moviesapi

//import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

class MovieAdapter:
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var dataSet: MutableList<MovieItems> = mutableListOf()
        set(value) {
        field = value
            notifyDataSetChanged()
        }

    enum class MovieLayout{
        ZERO, ONE, TWO
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return (0..2).random()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            MovieLayout.ZERO.ordinal ->{
                MovieVHOne(LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.movies_item_layout,
                        parent,
                        false
                    ))
            }
            MovieLayout.ONE.ordinal ->{
                MovieVHTwo(LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.movies_item_layout2,
                        parent,
                        false
                    ))
            }
            MovieLayout.TWO.ordinal ->{
                MovieVHThree(LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.movies_item_layout3,
                        parent,
                        false
                    ))
            }
            else->{throw Exception("Incorrect View Type")}
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is MovieVHOne->{
                holder.onBind(dataSet[position])
            }
            is MovieVHTwo->{
                holder.onBind(dataSet[position])
            }
            is MovieVHThree->{
                holder.onBind(dataSet[position])
            }
        }
    }
}