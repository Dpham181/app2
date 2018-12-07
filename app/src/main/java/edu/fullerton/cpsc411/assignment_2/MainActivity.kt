package edu.fullerton.cpsc411.assignment_2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.*


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























