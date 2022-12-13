package ru.samsung.itschool.mdev.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val list: List<Person>) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvName: TextView = itemView.findViewById(R.id.name)
        val tvPhone: TextView = itemView.findViewById(R.id.phoneNumber)
        val imgSex: ImageView = itemView.findViewById(R.id.sex)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myItemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(myItemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("RRR",list[position].name)
        holder.tvName.text = list[position].name
        holder.tvPhone.text = list[position].phoneNumber
        holder.imgSex.setImageResource(
            when (list[position].sex) {
                'M' -> R.drawable.ic_baseline_boy_24
            else -> R.drawable.ic_baseline_girl_24
        })
    }

    override fun getItemCount(): Int {
       return list.size
    }
}