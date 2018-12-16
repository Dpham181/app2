package edu.fullerton.cpsc411.assignment_2
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = MovieDbHelper.getInstance(this)

        db.insertNewMoive("Moive1" ,"test1","no")

        db.insertNewMoive("Moive2" ,"test2","harry")
        db.insertNewMoive("Moive 3" ,"test3","no")

        if (savedInstanceState == null) {

            Handler().postDelayed({

                supportFragmentManager.transaction(allowStateLoss = true) {


                    replace(R.id.Fragment_holder, LoginFragment())


                }
       }, 1000)


                }


        }


    }























