package edu.fullerton.cpsc411.assignment_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_useractivity.*
import kotlinx.android.synthetic.main.content_useractivity.*
import kotlinx.android.synthetic.main.movie_viewholder.*
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import android.R.attr.resource


class useractivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useractivity)


        // https://developer.android.com/reference/kotlin/android/widget/Toolbar
        setSupportActionBar(toolbar)

        // get username if logging
        val username = intent.getStringExtra("comefrom")
        toolbar.title = "Welcome " + username + "!"   // set appbar title to username


        // icon popup
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()


            val intent =  Intent(this, CreateMovieActivity::class.java).apply {
                putExtra("currentUser", username)
            }
            startActivity(intent)


        }


        /*                          Recycler view                 */
        // getting data from database return arraylist object
        val db = MovieDbHelper.getInstance(this)
        val listofmovies = db.AllMoive()


        Log.d("list of movies", listofmovies.toString())
        RecyclerViewMoive.layoutManager = LinearLayoutManager(this)

        RecyclerViewMoive.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val itemView = layoutInflater.inflate(R.layout.movie_viewholder, parent, false)
                return ViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.text1.text = listofmovies[position].title
                holder.text2.text = listofmovies[position].description

                val id = resources.getIdentifier(listofmovies[position].img, "drawable", packageName)

                val draw = ContextCompat.getDrawable(application, id)
                holder.text3.setImageDrawable(draw)
            }

            override fun getItemCount() = listofmovies.size


        }




    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action, menu)
        return true
    }





}
