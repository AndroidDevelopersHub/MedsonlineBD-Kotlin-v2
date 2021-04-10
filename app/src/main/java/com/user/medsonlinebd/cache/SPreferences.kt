package com.dana.money.data

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.user.medsonlinebd.MedsonlineBD


object SPreferences {


    private val id = "_id"


    private fun getSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setUserId(value: String?) {
        getSharedPreferences(MedsonlineBD.instance).edit().putString(id, value).apply()
    }

    fun getUserId(): String? {
        return getSharedPreferences(MedsonlineBD.instance).getString(id, null)
    }



}