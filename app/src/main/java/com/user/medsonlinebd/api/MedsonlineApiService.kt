package com.user.medsonlinebd.api

import com.user.medsonlinebd.data.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MedsonlineApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}