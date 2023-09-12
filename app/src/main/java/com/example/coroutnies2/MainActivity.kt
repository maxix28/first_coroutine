package com.example.coroutnies2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutnies2.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    val TAG= "MainActivity"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         //adf()

        Log.d(TAG, "Before runBlocking ")

      GlobalScope.launch (Dispatchers.IO){
            val time = measureTimeMillis {
                val b=  async { adf() }
                val a =  async {adf() }
                Log.d(TAG, "${b.await()}")
                Log.d(TAG, "${a.await()}")
        }
            Log.d(TAG, "Time $time")

            delay(5000L)
            Log.d(TAG, "End runBlocking ")

        }
        Log.d(TAG, "After runBlocking ")



    }
  suspend  fun adf():String{

      delay(4000L)


        return "gg"
    }
}