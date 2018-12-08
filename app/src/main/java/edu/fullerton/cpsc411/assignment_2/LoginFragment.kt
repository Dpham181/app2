package edu.fullerton.cpsc411.assignment_2


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import edu.fullerton.cpsc411.assignment_2.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

const val comefrom= "edu.fullerton.cpsc411.assignment_2.LoginFragment"

class LoginFragment : Fragment() {

    private val userModel by lazy { ViewModelProviders.of(this).get(UserModel::class.java) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.usermodel = userModel

        // using root for getting the fragment view
        val fragmentView = binding.root


        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        var username = ""
        val db = MovieDbHelper(this.activity?.applicationContext!!)
        var password =""
        val CurrentUser = Observer<String>{ LiveUser ->
            username = LiveUser
        }
        val Currentuserpass= Observer<String>{ LivePass ->
            password = LivePass
        }
        userModel.username.observe(this, CurrentUser)
        userModel.password.observe(this, Currentuserpass)
        register.setOnClickListener(){


            db.insertNewUser(username,password)


        }

        loginB.setOnClickListener(){
            if (db.loginUser(username,password)){
                // start new activity and sent the username to useractivity using put extra
                val intent =  Intent(activity, useractivity::class.java).apply {
                    putExtra(comefrom, username)
                }

                startActivity(intent) //call asynchronous
           }
            else
            {
                Log.d("soemthingwe", "teststs")
            }
        }




    }

}
