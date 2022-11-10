package com.example.mangaapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (var activity: Activity, val list:List<OutData>):ArrayAdapter<OutData>(activity,R.layout.iem1){
    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contexs = activity.layoutInflater

        val rowView = contexs.inflate(R.layout.iem1, parent, false)

        val images = rowView.findViewById<ImageView>(R.id.imgBanner)
        val title = rowView.findViewById<TextView>(R.id.txtTitle)
        val dec = rowView.findViewById<TextView>(R.id.txtDec)

        title.text = list[position].title
        title.text = list[position].dec
        images.setImageResource(list[position].image)

        return rowView

    }
}