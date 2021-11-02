package com.example.jsonpracticerequiredtask

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface {
    @Headers("Content-Type: application/json")
    @GET("/contacts/")
    fun showNames(): retrofit2.Call<ArrayList<namesListItem?>>
}