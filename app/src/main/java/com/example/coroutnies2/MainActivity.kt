package com.example.coroutnies2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutnies2.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG= "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         //adf()
        Log.d(TAG, "Before runBlocking ")
        runBlocking {
            launch (Dispatchers.IO){
                delay(3000)
                Log.d(TAG, "Finish IO")

            }
            launch (Dispatchers.IO){
                delay(6000)
                Log.d(TAG, "Finish IO")

            }


            Log.d(TAG, "Start runBlocking ")
            delay(5000L)
            Log.d(TAG, "End runBlocking ")

        }
        Log.d(TAG, "After runBlocking ")



    }
    fun adf(){
        GlobalScope.launch(newSingleThreadContext("fff")) {
            delay(4000L)


            withContext(Dispatchers.Main){
                binding.TXT.text="ferg"
                Log.d(TAG, "AAAAAAAAAA")

            }
        }




    }
}