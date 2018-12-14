package edu.fullerton.cpsc411.assignment_2

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



// viewholder getting two text view from movie_viewholder xml

class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val movietitle = item.findViewById<TextView>(R.id.movietitle)
    val moviedes = item.findViewById<TextView>(R.id.moviedes)
    val holder_image = item.findViewById<ImageView>(R.id.holder_image)
    val like = item.findViewById<View>(R.id.like)
    val disLike = item.findViewById<View>(R.id.dislike)
    val stars = item.findViewById<RatingBar>(R.id.ratingBar)
}
