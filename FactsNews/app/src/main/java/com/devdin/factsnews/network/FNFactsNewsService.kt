package com.devdin.factsnews.network

import com.devdin.factsnews.datamodel.FNFactResponse
import retrofit2.Call
import retrofit2.http.GET

interface FNFactsNewsService {

    @GET("facts.json")
    fun getFactsNews(): Call<FNFactResponse>

}