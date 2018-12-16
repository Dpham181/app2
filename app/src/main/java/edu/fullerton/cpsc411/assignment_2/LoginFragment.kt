package edu.fullerton.cpsc411.assignment_2


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
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


        // define var variable to get livedata from model
        var username = ""
        var password =""



        // Creating a alert Dialog
        // https://developer.android.com/guide/topics/ui/dialogs#kotlin
        val alertDialog: AlertDialog? = activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle("Thanks for joining us")
                setMessage("Your Account has been successfully created")
            }
            // Set other dialog properties

            // Create the AlertDialog
            builder.create()
        }



        // open SQLITE in this activity
        val db = MovieDbHelper.getInstance(this.activity!!)

        // GETTING TWO LIVEDATA FROM USER VIEWMODEL and assign to var defined
        val CurrentUser = Observer<String>{ LiveUser ->
            username = LiveUser
        }
        val Currentuserpass= Observer<String>{ LivePass ->
            password = LivePass
        }
        userModel.username.observe(this, CurrentUser)
        userModel.password.observe(this, Currentuserpass)



        // REGISTER BUUTON  -> INSERT USERNAME AND PASSWORD

        register.setOnClickListener() {


           if( db.insertNewUser(username,password)) {
               alertDialog?.setTitle("Thanks for joining us")
               alertDialog?.setMessage("Your Account has been successfully created")
               alertDialog?.show()

           }
            else {
               alertDialog?.setMessage("there is something wrong")
               alertDialog?.show()
           }


        }

        loginB.setOnClickListener(){
            if (db.loginUser(username,password)){
                // start new activity and sent the username to useractivity using put extra
                val intent =  Intent(activity, useractivity::class.java).apply {
                    putExtra("comefrom", username)
                }

                startActivity(intent) //call asynchronous
                activity!!.overridePendingTransition(R.anim.fade_in,R.anim.fade_out)

            }
            else
            {
                alertDialog?.setTitle("Oops!")
                alertDialog?.setMessage("SomeThing Wrong With Your Username OR Password")
                alertDialog?.show()
            }
        }




    }

}
