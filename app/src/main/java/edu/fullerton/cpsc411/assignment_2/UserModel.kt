package edu.fullerton.cpsc411.assignment_2

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel


open class UserModel : ViewModel(), Observable {


    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()



    // build in call back
    override fun addOnPropertyChangedCallback(
            callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(
            callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }


    var username = "";
    var password = "";

    fun UsernameTextChanged(s: CharSequence) {


        if(s.isNotEmpty()) {
            Log.d("USERNAME", s.toString())
            username = s.toString();

        }else{
            Log.d("USERNAME", "EMPTY")

        }

    }
    // second text on change to get update for net speed called mbps
    fun PasswordTextChanged(s: CharSequence) {

        if (s.isNotEmpty()) {
            Log.d("PASSWORD", s.toString())
            password = s.toString();
        }
        else
        {
            Log.d("PASSWORD", "EMPTY")

        }
    }




}




