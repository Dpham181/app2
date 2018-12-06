package edu.fullerton.cpsc411.assignment_2
import android.content.ContentValues
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.INVISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

import androidx.fragment.app.*
import kotlinx.android.synthetic.main.fragment_login.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {


                supportFragmentManager.transaction(allowStateLoss = true) {

                    add(R.id.Fragment_holder, LoginFragment())


                }


            }

        }


    }























