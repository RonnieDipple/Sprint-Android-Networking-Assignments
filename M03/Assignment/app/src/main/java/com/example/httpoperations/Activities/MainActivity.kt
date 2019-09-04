package com.example.httpoperations.Activities

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



    private fun isNetworkConnected(): Boolean{
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true

    }
}
