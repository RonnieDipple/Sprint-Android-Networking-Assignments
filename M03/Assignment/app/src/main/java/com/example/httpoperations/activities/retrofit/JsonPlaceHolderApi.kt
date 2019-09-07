package com.example.httpoperations.activities.retrofit
import retrofit2.Call
import com.example.httpoperations.activities.model.Employee
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface JsonPlaceHolderApi {

    @GET("employees")
    fun getEmployees(): Call<List<Employee>>

    @GET("employees/{id}")
    fun getEmployeesId(@Path("id")employeeId: String): Call<List<Employee>>// PATH

    @GET("employees")
    fun getEmployeesAge(@Query("age") employeeAge: Int): Call<List<Employee>>

    @POST("employees")
    fun addNewEmployee(@Body employee: Employee): Call<Employee>

    @PUT("employees")
    fun updateEmployee(@Body employee: Employee): Call<Employee>

    @DELETE("employees/{id}")
    fun deleteEmployeeById(@Path("id") id: Int): Call<Void>

    class Factory {

        companion object {

            const val BASE_URL = "https://demo8143297.mockable.io"

            fun create(): JsonPlaceHolderApi {

                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                logger.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(JsonPlaceHolderApi::class.java)
            }
        }
    }

}