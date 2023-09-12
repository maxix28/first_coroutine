package com.example.coroutnies2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
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



binding.TXT.setOnClickListener {
    lifecycleScope.launch {
        while(true){
            delay(1000)
            Log.d(TAG, "Still working ")

        }
    }
    lifecycleScope.launch {
        delay(5000)
        Intent(this@MainActivity,SecondActivity::class.java).also{
            startActivity(it)
            finish()
        }
    }
}
    }
  suspend  fun adf():String{

      delay(4000L)


        return "gg"
    }
}