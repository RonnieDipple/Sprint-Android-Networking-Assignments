package com.example.httpoperations.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.R
import com.example.httpoperations.activities.retrofit.JsonPlaceHolderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DeleteActivity : AppCompatActivity(), Callback<Void> {
    //Gives a response in case of failure
    override fun onFailure(call: Call<Void>, t: Throwable) {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

    }
    //Responds based on if call successful or not

    override fun onResponse(call: Call<Void>, response: Response<Void>) {
        if (response.isSuccessful){
            Toast.makeText(this, "Successfully deleted employee", Toast.LENGTH_SHORT).show()
        }else{

            Toast.makeText(this, "Failed to delete the employee", Toast.LENGTH_SHORT).show()

        }
    }


    //<-Initialises an instance of the JsonPlaceHolderApi interface on the left
    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deleteactivity)

        //Initiates the factory class in JsonPlaceHolderApi
        employeeService = JsonPlaceHolderApi.Factory.create()

        //initiates deletion of employee
        deleteEmployeeId()
    }

    private fun deleteEmployeeId(){

        employeeService.deleteEmployeeById(1).enqueue(this)
    }
}
