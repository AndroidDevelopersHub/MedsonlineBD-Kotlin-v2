package com.parallax.showofff.api

import android.content.Intent
import android.util.Log
import com.dana.money.data.SPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class OkHttpClient {
    val okHttpClientUser: OkHttpClient
        get() {
            try {
                val builder = OkHttpClient.Builder()
                builder.connectTimeout(30, TimeUnit.SECONDS)
                builder.readTimeout(30, TimeUnit.SECONDS)
                builder.writeTimeout(30, TimeUnit.SECONDS)


                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                builder.interceptors().add(interceptor)

                builder.addInterceptor { chain ->

                    val authorization = SPreferences.getUserId()
                    Log.d("UserAUTH", "" + authorization)

                    val newRequest = chain.request().newBuilder()
                        .addHeader("x-auth-token", authorization ?: "")
                        .build()

                    val response = chain.proceed(newRequest)

                    if (response.code == 401) {
                        //Signout user
                        return@addInterceptor response
                    }

                    return@addInterceptor response
                }
                return builder.build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }


    val okHttpClientglobal: OkHttpClient
        get() {
            try {
                val builder = OkHttpClient.Builder()
                builder.connectTimeout(30, TimeUnit.SECONDS)
                builder.readTimeout(30, TimeUnit.SECONDS)
                builder.writeTimeout(30, TimeUnit.SECONDS)
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                builder.interceptors().add(interceptor)
                return builder.build()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }

}