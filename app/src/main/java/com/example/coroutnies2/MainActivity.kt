package com.example.coroutnies2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.coroutnies2.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis
import com.google.firebase.FirebaseApp

data class Person (val name :String="", val age:Int=-1)
class MainActivity : AppCompatActivity() {
    val TAG= "MainActivity"
    lateinit var binding: ActivityMainBinding
    lateinit var per1:Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        val tutorialDocument =  Firebase.firestore.collection("coroutines").document("tutorial1")
        val peter11= Person("Peter1",2)
        GlobalScope.launch (Dispatchers.IO){
            tutorialDocument.set(peter11)
            //println( "!!!!!!!!!!!!!!!!!!!!!!!!!"+tutorialDocument.get())
            tutorialDocument.get() .addOnSuccessListener {
Toast.makeText(this@MainActivity,"Works",Toast.LENGTH_SHORT).show()
                if (it.exists()) {
                   var  per1 = it.toObject(Person::class.java)
                    binding.TXT.text = "${per1}"
                    println(per1)

                }



        }
            delay(timeMillis = 5000)
//            if(per1!=null) {
//                withContext(Dispatchers.Main) {
//                    binding.TXT.text = "${per1}"
//                }
//            }
        }
        binding.TXT.text = "Wait"



    }
}

