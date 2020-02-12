package com.devdin.factsnews.network

import android.util.Log
import com.devdin.factsnews.datamodel.FNFactResponse
import com.devdin.factsnews.utils.FNLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FNRestClient {

    companion object Rest{
       fun getFacts(callback:FNRestCallback<FNFactResponse>){
           val factsService = FNRetrofitManager.getRetrofit().create(FNFactsNewsService::class.java)
           val call = factsService.getFactsNews()
           call.enqueue(object : Callback<FNFactResponse> {
               override fun onResponse(call: Call<FNFactResponse>, response: Response<FNFactResponse>) {
                   if (response.code() == 200) {
                          FNLogger.log("FNRestClient.getFacts.OnSuccess()",response.body().toString())
                       callback.onSuccess(response.body())
                   }
               }
               override fun onFailure(call: Call<FNFactResponse>, t: Throwable) {
                   FNLogger.log("FNRestClient.getFacts.onFailure()",t.printStackTrace().toString())
                     callback.onFailure()
               }
           })
       }
    }
}