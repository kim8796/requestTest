package com.example.requesttest
//54.180.82.220
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody

import java.io.IOException

data class Users (
    @SerializedName(value = "u_id")
    val uid : String,
    @SerializedName(value = "u_name")
    val name : String
)



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            var user = Users("test1","test1")

            var gson = GsonBuilder().setPrettyPrinting().create()
            var json = gson.toJson(user)


            jsontest.setText(json)


            var requestHttp : RequestHTTP = RequestHTTP()
            var ret = requestHttp.execute(json).get()
            responsetest.setText(ret)

            //var t = Toast.makeText(applicationContext,json,Toast.LENGTH_LONG)
            //t.show()








            //responsetest.setText(response.body.toString())
           // print(response.body.toString())

//            ok.newCall(request).enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    e.printStackTrace()
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    var res = response.body.toString()
//                    responsetest.setText(res)
//                }
//            })




        }
        catch (e : IOException){
            e.printStackTrace()
        }
    }


    companion object {
        val MEDIA_TYPE_JSON = "'application/json; charset=utf-8".toMediaType() //'content-type': 'application/json; charset=utf-8'
    }
}
