package edu.fullerton.cpsc411.assignment_2


import android.content.ContentValues
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import edu.fullerton.cpsc411.assignment_2.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {



        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.usermodel = ViewModelProviders.of(this).get(UserModel::class.java)

        // using root for getting the fragment view
        val fragmentView = binding.root


        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textInputLayout.visibility = INVISIBLE
        textInputLayout2.visibility = INVISIBLE
        register.visibility = INVISIBLE
        Handler().postDelayed({

            logo.visibility = INVISIBLE
            textInputLayout.visibility = VISIBLE
            textInputLayout2.visibility = VISIBLE
            register.visibility = VISIBLE


        }, 3000)



       val db = MovieDbHelper(this.activity?.applicationContext!!)

        register.setOnClickListener(){
           db.insertUser()
            db.close()
        }

    }

}
