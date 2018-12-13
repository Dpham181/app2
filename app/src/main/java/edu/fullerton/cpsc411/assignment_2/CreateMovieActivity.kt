package edu.fullerton.cpsc411.assignment_2

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import edu.fullerton.cpsc411.assignment_2.R.string.new_movie_title
import kotlinx.android.synthetic.main.activity_create_movie.*
import kotlinx.android.synthetic.main.content_useractivity.*

class CreateMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_movie)

        val db = MovieDbHelper.getInstance(this)

        val notEmpty: EditText.() -> Boolean = {text.isNotEmpty()}
        save_button.setOnClickListener { view ->
            if (notEmpty(new_movie_title) && notEmpty(new_description)) {


                val newMovie = new_movie_title.text.toString()
                val newDes = new_description.text.toString()
                val isExist = db.isMovieCreated(newMovie)

                if (isExist == 0) {

                    db.insertNewMoive(newMovie,
                            newDes,
                            "no")
                    Snackbar.make(view, "Movie is added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()


                    finish()

//                    val intent =  Intent(this, useractivity::class.java)
//                    startActivity(intent)
//                    onBackPressed()





                    } else {
                    Snackbar.make(view, "Cannot add this movie or movie is already existed", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show()
                }
            }
        }
    }



}
