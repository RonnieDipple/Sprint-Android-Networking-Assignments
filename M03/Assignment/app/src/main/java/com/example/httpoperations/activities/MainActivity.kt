package com.example.httpoperations.activities

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.httpoperations.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //series of onclick listeners with snack bar popups and intents

        btn_get.setOnClickListener {
            if (!isNetworkConnected()){
                Snackbar.make(it, "Please check your connection and try again",Snackbar.LENGTH_SHORT)
            }else{

                startActivity(Intent(this, GetActivity::class.java))

            }

        }

        btn_post.setOnClickListener {
            if (!isNetworkConnected()){
                Snackbar.make(it, "Please check your connection and try again",Snackbar.LENGTH_SHORT)
            }else{

                startActivity(Intent(this, PostActivity::class.java))

            }

        }

        btn_put.setOnClickListener {
            if (!isNetworkConnected()){
                Snackbar.make(it, "Please check your connection and try again",Snackbar.LENGTH_SHORT)
            }else{

                startActivity(Intent(this, PutActivity::class.java))

            }

        }

        btn_delete.setOnClickListener {
            if (!isNetworkConnected()){
                Snackbar.make(it, "Please check your connection and try again",Snackbar.LENGTH_SHORT)
            }else{

                startActivity(Intent(this, DeleteActivity::class.java))

            }

        }



    }



    //Checks for connectivity
    private fun isNetworkConnected(): Boolean{
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true

    }
}
