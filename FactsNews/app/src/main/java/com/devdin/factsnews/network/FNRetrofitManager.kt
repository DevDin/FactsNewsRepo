package com.devdin.factsnews.network

import com.devdin.factsnews.utils.Constants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FNRetrofitManager {
    companion object GetRetrofit {
      private  fun getHttpClient(): OkHttpClient {

            val okHttpClientBuilder = OkHttpClient.Builder()
            //Add interceptors
            okHttpClientBuilder.addInterceptor { chain ->
                val origReq = chain.request()

                //TODO: This need to be rechecked while implementing token
                val requestBuilder = origReq.newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            val okHttpClient: OkHttpClient = okHttpClientBuilder
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
            return okHttpClient
        }

        fun getRetrofit(): Retrofit {
            val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .baseUrl(Constants.BASE_URL)
            retrofitBuilder.client(getHttpClient())
            return retrofitBuilder.build()
        }
    }
}
