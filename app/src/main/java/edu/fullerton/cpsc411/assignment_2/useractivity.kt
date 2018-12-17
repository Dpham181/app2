package edu.fullerton.cpsc411.assignment_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.activity_useractivity.*
import kotlinx.android.synthetic.main.content_useractivity.*
import androidx.core.content.ContextCompat
import android.view.MenuItem


class useractivity : AppCompatActivity() {



    private val db = MovieDbHelper.getInstance(this)
    private val listofmovies = db.AllMoive()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useractivity)


        // https://developer.android.com/reference/kotlin/android/widget/Toolbar
        setSupportActionBar(toolbar)

        // get username if logging
        val username = intent.getStringExtra("comefrom")
        toolbar.title = "Welcome " + username + "!"   // set appbar title to username


        // icon popup
        fab.setOnClickListener {

            val intent =  Intent(this, CreateMovieActivity::class.java)
            startActivity(intent)


        }


        /*                          Recycler view                 */
        // getting data from database return arraylist object

        RecyclerViewMoive.layoutManager = LinearLayoutManager(this)

        RecyclerViewMoive.adapter = object : RecyclerView.Adapter<ViewHolder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val itemView = layoutInflater.inflate(R.layout.movie_viewholder, parent, false)
                return ViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: ViewHolder, position: Int) {

                holder.movietitle.text = listofmovies[position].title
                holder.moviedes.text = listofmovies[position].description
                holder.stars.rating = listofmovies[position].stars


                // pic img getting id of img from drawable then set holder
                val id = resources.getIdentifier(listofmovies[position].img, "drawable", packageName)
                val draw = ContextCompat.getDrawable(application, id)
                holder.holder_image.setImageDrawable(draw)


                val stars = db.getStars(position+1)  // getting stars from db

                // like buuton click then call db to get count of like in sqlite
                // then update like + 1 and update
                holder.like.setOnClickListener() {
                    val getlike = db.getmovielike(position + 1)

                    db.like(getlike, position + 1)

                    getlike.let{
                        when
                        {
                            it % 5 == 0 -> db.incrementStars(stars, position + 1)
                        }
                    }


                    RecyclerViewMoive.adapter!!.notifyItemChanged(position)
                    val newlist = db.AllMoive()
                    listofmovies.clear()
                    listofmovies.addAll(newlist)
                    holder.stars.rating = listofmovies[position].stars

                }

                holder.disLike.setOnClickListener() {
                    val getlike = db.getmovielike(position + 1)

                    db.dislike(getlike, position + 1)

                    getlike.let{
                        when
                        {
                            it % 5 == 0 -> db.decrementStars(stars, position + 1)
                        }
                    }


                    RecyclerViewMoive.adapter!!.notifyItemChanged(position)
                    val newlist = db.AllMoive()
                    listofmovies.clear()
                    listofmovies.addAll(newlist)
                    holder.stars.rating = listofmovies[position].stars

                }



            }
            override fun getItemCount() = listofmovies.size


        }




    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        return when (item?.itemId) // ITEMS NOT NULL CHECK BY USING ?
        {
            R.id.Profile -> {

                true;

            }


            R.id.Contact -> {

                val intent =  Intent(this, ContactActivity::class.java)
                startActivity(intent)

                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)


                true;
            }

            R.id.Location -> {

                val intent =  Intent(this, location::class.java)
                startActivity(intent)

                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)


                true;
            }

            R.id.LogOut -> {
                finish()
                true;
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
    private fun onUpdateRecylerview(){
        val Updatedlist = db.AllMoive()
        if(Updatedlist.size > listofmovies.size){
            Log.d("new list", Updatedlist.toString())
            listofmovies.clear()
            listofmovies.addAll(Updatedlist)
            Log.d("after update list", listofmovies.toString())
            RecyclerViewMoive.adapter!!.notifyDataSetChanged()

        }
    }
    override fun onResume() {
        super.onResume()
        onUpdateRecylerview()
    }



}
