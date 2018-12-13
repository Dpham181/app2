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

        db.insertNewMoive("Moive1" ,"test1","harry")

        db.insertNewMoive("Moive2" ,"test2","no")
        db.insertNewMoive("Moive 3" ,"test3","harry")

        if (savedInstanceState == null) {

            Handler().postDelayed({
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

                supportFragmentManager.transaction(allowStateLoss = true) {


                    replace(R.id.Fragment_holder, LoginFragment())




                }
       }, 0)


                }




        }


    }























