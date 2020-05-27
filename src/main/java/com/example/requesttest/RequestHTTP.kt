package com.example.requesttest

import android.os.AsyncTask
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class RequestHTTP : AsyncTask<String,Void,String>() {

    var ok: OkHttpClient = OkHttpClient()
    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

    }

    override fun doInBackground(vararg params: String?): String {
        var url =  "http://54.180.82.220/users/"

        var request: Request = Request.Builder().url(url).post(params[0]!!.toRequestBody(MainActivity.MEDIA_TYPE_JSON)).build()
        ok.newCall(request).execute().use { response ->
            if(!response.isSuccessful) throw IOException("Unexpected code $response")
            //println(response.body!!.string());
            return response.body!!.string()
        }
    }

}