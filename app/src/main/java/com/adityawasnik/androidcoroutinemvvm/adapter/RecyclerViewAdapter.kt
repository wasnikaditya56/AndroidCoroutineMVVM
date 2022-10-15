package com.adityawasnik.androidcoroutinemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adityawasnik.androidcoroutinemvvm.R
import com.adityawasnik.androidcoroutinemvvm.model.RecyclerData
import com.squareup.picasso.Picasso
import java.util.ArrayList


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<RecyclerData>()

    fun setUpdateData(items:ArrayList<RecyclerData>){
        this.items = items
        notifyDataSetChanged()
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imageThumb = view.findViewById<ImageView>(R.id.imageThumb )
        val tvTitle = view.findViewById<TextView>(R.id.tvTitle )
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc )
        fun bind(data: RecyclerData){
            tvTitle.text = data.name
            tvDesc.text = data.description

            val url = data.owner.avatar_url
            Picasso.get()
                .load(url)
                .into(imageThumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
       return items.size
    }


}