package com.example.task13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val request = Request.Builder()
            .url("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ff49fcd4d4a08aa6aafb6ea3de826464&tags=cat&format=json&nojsoncallback=1")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: okio.IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) throw okio.IOException("Unexpected code $response")

                    for ((name, value) in response.headers) {
                        Timber.i("Response header $name: $value")
                    }

                    Timber.i("All body from response: \n${response.body!!.string()}")
                }
            }
        })

        Timber.i("info log")
    }
}
