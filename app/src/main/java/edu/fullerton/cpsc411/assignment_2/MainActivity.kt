package edu.fullerton.cpsc411.assignment_2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = MovieDbHelper.getInstance(this)

        db.insertNewMoive("Moive1" ,"test1")

        db.insertNewMoive("Moive2" ,"test2")
        db.insertNewMoive("Moive 3" ,"test3")
        db.AllMoive()

        if (savedInstanceState == null) {


                supportFragmentManager.transaction(allowStateLoss = true) {

                    add(R.id.Fragment_holder, LoginFragment())


                }


            }

        }


    }























