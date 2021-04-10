package com.user.medsonlinebd.api

import com.parallaxlogic.ekshop.utils.NetworkHelper
import java.lang.Exception

object ApiResponseProvider {

    const val ON_FAILURE_MESSAGE = "Please Check your Internet Connection"
    const val TIME_OUT = "Connection Timeout "
    const val LIMIT = 20


//    suspend fun getJustForYou(
//        page: Int,
//        callBack: (ApiResponse<ProductResponse>) -> Unit
//    ) {
//
//        try {
//
//            if (NetworkHelper(Ekshop.instance).isNetworkConnected()) {
//                apiServices.getJustForYou(50, page).let {
//                    if (it.isSuccessful)
//                        callBack(ApiResponse(code = it.code(), data = it.body()))
//                    else
//                        callBack(ApiResponse(code = it.code(), message = TIME_OUT + it.code()))
//                }
//            } else
//                callBack(ApiResponse(code = 400, message = "No internet connectivity found"))
//
//        } catch (e: Exception) {
//        }
//
//
//    }


}