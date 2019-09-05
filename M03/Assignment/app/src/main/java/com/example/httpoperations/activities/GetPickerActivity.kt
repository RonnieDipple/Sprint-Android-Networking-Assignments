package com.example.httpoperations.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.httpoperations.R
import kotlinx.android.synthetic.main.activity_getpickeractivity.*

class GetPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getpickeractivity)

        //Series of onclick listeners with intents, intent.putextra sends key value pairs to GetActivity
        //where they will be received

        btn_get_call.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "simple")
            startActivity(intent)

        }

        btn_get_call_path.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "path")
            startActivity(intent)

        }

        btn_get_query.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "query")
            startActivity(intent)

        }

    }
}
