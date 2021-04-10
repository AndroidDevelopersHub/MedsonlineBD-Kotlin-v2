package com.user.medsonlinebd.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.mindorks.retrofit.coroutines.utils.Resource
import com.user.medsonlinebd.api.apiServices
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    fun getString(): String {
        return "hello"
    }


    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiServices.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


}