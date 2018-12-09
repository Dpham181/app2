package edu.fullerton.cpsc411.assignment_2

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_useractivity.*

class useractivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useractivity)


         // https://developer.android.com/reference/kotlin/android/widget/Toolbar
        setSupportActionBar(toolbar)

        // get username if logging
        val username = intent.getStringExtra(comefrom)
        toolbar.title = "Welcome!!  " + username   // set appbar title to username


        // icon popup
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action, menu)
        return true
    }

}
