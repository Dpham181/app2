package edu.fullerton.cpsc411.assignment_2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



// viewholder getting two text view from movie_viewholder xml

class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val text1 = item.findViewById<TextView>(R.id.movietitle)
    val text2 = item.findViewById<TextView>(R.id.moviedes)
}
