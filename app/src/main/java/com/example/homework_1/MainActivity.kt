    package com.example.homework_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {
        lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         db = Firebase.firestore

        add.setOnClickListener {
            if (name1.text.isNotEmpty()&&email1.text.isNotEmpty()){
                val name = name1.text.toString()
                val email = email1.text.toString()
                addUserToDB(name,email)
            }else{
                Toast.makeText(this,"تأكد من ادخالك للبيانات كاملة",Toast.LENGTH_SHORT).show()
            }
        }
    }

          fun addUserToDB(name : String , email : String){
           val u =  hashMapOf("name" to name , "email" to email)
            db.collection("user")
                    .add(u)
                    .addOnSuccessListener {_->
                        Toast.makeText(this,"نجحت العمليه",Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                    Toast.makeText(this,"فشلت العملية",Toast.LENGTH_SHORT).show()
                }
        }
}