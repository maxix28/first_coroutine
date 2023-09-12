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
        val job= GlobalScope.launch (Dispatchers.Default){
repeat(7) {
    if(isActive) {
        delay(3000)

        Log.d(TAG, "Job in runBlocking ")
    }
}
        }
        Log.d(TAG, "Before runBlocking ")
        runBlocking {
            launch (Dispatchers.IO){
                delay(3000)
                Log.d(TAG, "Finish IO  1")

            }
            launch (Dispatchers.IO){
                delay(6000)
                Log.d(TAG, "Finish IO 2 ")

            }
            job.join()
            delay(3000L)

            Log.d(TAG, "Start runBlocking ")
            job.cancel()
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