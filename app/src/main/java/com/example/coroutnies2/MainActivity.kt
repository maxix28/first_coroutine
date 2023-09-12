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

         adf()
        Log.d(TAG, "later")



    }
    fun adf(){
        GlobalScope.launch(Dispatchers.IO) {
            delay(4000L)
            Log.d(TAG,"LAla")

            withContext(Dispatchers.Main){
                binding.TXT.text="ferg"
            }
        }


      

    }
}