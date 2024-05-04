 package com.example.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.instagramclone.Models.User
import com.example.instagramclone.Utils.USER_NODE
import com.example.instagramclone.Utils.USER_PROFILE_FOLDER
import com.example.instagramclone.Utils.uploadImage
import com.example.instagramclone.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

 class SignUp : AppCompatActivity() {
     val binding by lazy {
         ActivitySignUpBinding.inflate(layoutInflater)
     }
     lateinit var user : User
     private val launcher = registerForActivityResult(ActivityResultContracts.GetContent()){
             uri ->
         uri?.let{
             uploadImage(uri,USER_PROFILE_FOLDER) { imageUrl ->
                 user.image = imageUrl
                 Firebase.firestore.collection(USER_NODE).document(Firebase.auth.currentUser!!.uid).set(user).addOnSuccessListener { Toast.makeText(this@SignUp,"Login Successful",Toast.LENGTH_SHORT).show() }
             }
         }
     }
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(binding.root)
         user = User()
         binding.signup.setOnClickListener{
             if(binding.name.editText?.text.toString().equals("") or
                 binding.email.editText?.text.toString().equals("") or
                 binding.password.editText?.text.toString().equals("")
             ) {
                 Toast.makeText(this@SignUp,"Please fill the required details",Toast.LENGTH_SHORT).show()
             }
             else {
                 FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                     binding.email.editText?.text.toString(),
                     binding.password.editText?.text.toString()
                 ).addOnCompleteListener {
                         result->
                     if(result.isSuccessful){
                         user.name = binding.name.editText?.text.toString()
                         user.password = binding.password.editText?.text.toString()
                         user.email = binding.email.editText?.text.toString()
                         Firebase.firestore.collection(USER_NODE).document(Firebase.auth.currentUser!!.uid).set(user)
                             .addOnSuccessListener {
                                 runOnUiThread {
                                     startActivity(Intent(this@SignUp, HomeActivity::class.java))

                                 }
                             }
                     }
                     else
                         Toast.makeText(this@SignUp,result.exception?.localizedMessage,Toast.LENGTH_SHORT).show()
                 }
             }
         }
         binding.addImage.setOnClickListener {
             launcher.launch("image/*")
         }
         binding.login.setOnClickListener{
             startActivity((Intent(this@SignUp,LoginActivity::class.java)))
             finish()
         }
     }
 }