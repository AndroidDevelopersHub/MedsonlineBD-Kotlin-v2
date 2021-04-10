package com.user.medsonlinebd.api



import com.parallax.showofff.api.OkHttpClient
import com.parallax.showofff.utils.API_BASE_URL

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


var apiServices = ApiConfig().medsonlineApiService
var apiServicesUser = ApiConfig().medsonlineUserApiService



class ApiConfig {



    //Without Header Token
    private var medsonlineGuestRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient().okHttpClientglobal)
        .baseUrl(API_BASE_URL)
        .build()

    var medsonlineApiService: MedsonlineApiService =
        medsonlineGuestRetrofit.create(MedsonlineApiService::class.java)




    //With Header Token
    private var medsonlineUserRetrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient().okHttpClientUser)
        .baseUrl(API_BASE_URL)
        .build()

    var medsonlineUserApiService: MedsonlineApiService =
        medsonlineUserRetrofit.create(MedsonlineApiService::class.java)


}


