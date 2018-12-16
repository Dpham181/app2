package edu.fullerton.cpsc411.assignment_2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


open class UserModel() : ViewModel() {



    val username: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val password: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun UsernameTextChanged(s: CharSequence) {


        if(s.isNotEmpty()) {
            Log.d("USERNAME text change", s.toString())
            username.setValue(s.toString())

        }else{
            Log.d("USERNAME", "EMPTY")

        }

    }
   
    fun PasswordTextChanged(s: CharSequence) {

        if (s.isNotEmpty()) {
            Log.d("PASSWORD", s.toString())
            password.setValue(s.toString())
        }
        else
        {
            Log.d("PASSWORD", "EMPTY")
        }
    }

}




