package com.example.httpoperations.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.httpoperations.R
import com.example.httpoperations.activities.model.Employee
import com.example.httpoperations.activities.retrofit.JsonPlaceHolderApi
import retrofit2.*


class GetActivity : AppCompatActivity(), Callback<List<Employee>>{

    lateinit var employeeService: JsonPlaceHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getactivity)

        //<-Initialises an instance of the JsonPlaceHolderApi interface on the left
        employeeService = JsonPlaceHolderApi.Factory.create()

        //Gets the key values from the intent.putextra located in GetPickerActivity
        val type = intent.getStringExtra("get")
        if (type == "simple"){
            title = "Get - Simple Request"
            getEmployees()
        }else if (type == "path"){
            title = "Get - Path Parameter: EmployeeId - 2"
            getEmployeesId("2")
        }else{
            title = "Get - Query Parameter: Age - 45"
            getEmployeesAge(45)
        }



    }


    //Gets all the employees

    private fun getEmployees(){

       employeeService.getEmployees().enqueue(this)

    }

    //Gets the employee id number

    private fun getEmployeesId(employeeId: String){
        employeeService.getEmployeesId(employeeId).enqueue(this)

    }

    //Gets the employee age

    private fun getEmployeesAge(age: Int){
        employeeService.getEmployeesAge(age).enqueue(this)

    }

    //Governs what to do on for example connection failure, in this case a toast pops up

    override fun onFailure(call: Call<List<Employee>>, t: Throwable) {
        Toast.makeText(this@GetActivity, "Failed", Toast.LENGTH_SHORT).show()
    }

    //Governs what to do on for example connection response, in this case a toast pops up
    override fun onResponse(call: Call<List<Employee>>, response: Response<List<Employee>>) {

        response.body()?.let {
            Toast.makeText(this@GetActivity, it.toString(), Toast.LENGTH_SHORT).show()}


    }
}
