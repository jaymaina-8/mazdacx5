package com.example.mazdacx5.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.mazdacx5.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel (
    var navController: NavHostController,
    var context: Context
) {
    var mAuth: FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()

        fun signup(fname: String, lname: String, email: String, pass: String) {


            if (fname.isEmpty() && lname.isEmpty() && email.isEmpty() && email.isEmpty()
            ) {
             Toast.makeText(context,"please fill in all details", Toast.LENGTH_LONG).show()

            }
        else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {

                if (it.isSuccessful){
                    var userdata= User(fname,lname,email,pass,mAuth.currentUser!!.uid)
                    var regRef= FirebaseDatabase.getInstance().getReference().child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {  }

                    if (it.isSuccessful){
                        Toast.makeText(context,"Successfully"+"created an account", Toast.LENGTH_LONG).show()


                    }
                    else{

                        Toast.makeText(context,"failed to create an account", Toast.LENGTH_LONG).show()

                    }
                }
            }


        }
        }
    }
}