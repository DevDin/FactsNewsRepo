package com.devdin.factsnews.utils

import android.content.Context
import com.devdin.factsnews.datamodel.FNFactResponse
import com.google.gson.Gson
import java.io.IOException

class TestDataProvider {
    companion object Data {
        fun getData(context: Context): FNFactResponse {
            lateinit var jsonString: String
            try {
                jsonString =
                    context.assets.open("facts.json").bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
            }

            lateinit var response: FNFactResponse
            if (jsonString != null) {
                response = Gson().fromJson(jsonString, FNFactResponse::class.java)
            }


            return response
        }
    }
}