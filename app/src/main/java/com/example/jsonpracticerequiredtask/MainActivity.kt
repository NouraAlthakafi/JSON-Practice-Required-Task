package com.example.jsonpracticerequiredtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var etNumber: EditText
    lateinit var btnG: Button
    lateinit var tvName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNumber = findViewById(R.id.etNumber)
        btnG = findViewById(R.id.button)
        tvName = findViewById(R.id.tvName)
        val apiInterface = APINames().getName()?.create(APIInterface::class.java)
        btnG.setOnClickListener {
            etNumber.text.toString().toInt()
            val call: Call<ArrayList<namesListItem?>> = apiInterface!!.showNames()
            call?.enqueue(object: Callback<ArrayList<namesListItem?>> {
                override fun onResponse(
                    call: Call<ArrayList<namesListItem?>>,
                    response: Response<ArrayList<namesListItem?>>
                ) {
                    val resource = response.body()!!
                    tvName.text = resource[etNumber.text.toString().toInt()]?.name
                }

                override fun onFailure(call: Call<ArrayList<namesListItem?>>, t: Throwable) {
                    Log.d("MainActivity", "${t.message}")
                }
            })
        }
    }
}
