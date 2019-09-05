package com.example.httpoperations.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.R
import com.example.httpoperations.activities.model.Employee
import com.example.httpoperations.activities.retrofit.JsonPlaceHolderApi
import retrofit2.*

class PutActivity : AppCompatActivity(), Callback<Employee> {

    //See DeleteActivity/GetActivity for more details as this is mainly boilerplate
    override fun onFailure(call: Call<Employee>, t: Throwable) {
        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Employee>, response: Response<Employee>) {
        response.body()?.let {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_putactivity)

        employeeService = JsonPlaceHolderApi.Factory.create()
        updateEmployee()
    }

    private fun updateEmployee(){
        val employee = Employee("Steve", 1, 30, "Principal Egnineer")
        employeeService.updateEmployee(employee).enqueue(this)
    }
}
