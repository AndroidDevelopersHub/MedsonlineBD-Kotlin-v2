package com.parallaxlogic.ekshop.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Bitmap
import android.provider.Settings
import android.text.TextUtils
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.cardview.widget.CardView
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import androidx.core.content.ContextCompat


object AppUtils {

    lateinit var progressDialog: ProgressDialog

    fun showKeyboard(activity: Activity, editText: EditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        } catch (e: Exception) {

        }
    }

    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        try {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {

        }
    }


    fun removeBrackets(text: String): String {
        return text.replace("[", "").replace("]", "")
    }

    fun getDeviceID(context: Context): String? {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID)
    }


    fun getDaysDifference(fromDate: Date?, toDate: Date?): Long {
        return if (fromDate == null || toDate == null) 0 else ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24))
    }


    fun showLoading(activity: Activity, message: String = "Loading..") {
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    fun hideLoading() {
        if (progressDialog != null && progressDialog?.isShowing) {
            progressDialog?.dismiss()
        }
    }

    fun getDateFormat(date: String): String {
        var date =
            SimpleDateFormat("yyyy-MM-dd").parse(date)
        var a = SimpleDateFormat("yyyy-MM-dd").format(date)
        return a
    }


    fun isValidPhoneNumber(number: String?): Boolean {
        return number != null && number != "" && number.length < 11 && number.length > 9 && TextUtils.isDigitsOnly(
            "0123456789"
        )
    }

    fun isValidOTP(number: String?): Boolean {
        return number != null && number != "" && number.length < 5 && number.length > 3 && TextUtils.isDigitsOnly(
            "0123456789"
        )
    }

    fun isValidPassword(number: String?): Boolean {
        return number != null && number != "" && number.length < 15 && number.length > 1
    }


    fun getSubstring(st: String): String {
        if (st.length > 25)
            return st.substring(0, 22).toString() + " . . ."
        else
            return st
    }

    fun getBracketText(value: String): String {
        return "(" + value + ")"
    }
    fun getMainPhone(st: String): String {

        return st.substring(5, st.length)

    }


    fun Bullet() {
//        val tv = findViewById(R.id.textView1) as TextView
//        val circle = "\u25CF"
//        val sentence = "$circle  Hello its me\n"
//        tv.text = sentence
    }




    fun formatDateString(string : String): String {

        val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.ENGLISH)
        val date : Date = inputFormat.parse(string)
        val dateFormat: DateFormat = SimpleDateFormat("MMM dd, yyyy hh.mm aa")
        val dateString = dateFormat.format(date).toString()

        println("date :: $date")
        println("date :: $dateString")

        return dateString

    }

    fun formatJavaDate(string : String): Date {
        val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.ENGLISH)
        val date : Date = inputFormat.parse(string)
        return date

    }

    fun adjustTextSize(textView: TextView) {

        val textLength = textView.length()

        if (textLength > 10){

            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP ,4F)

        }
        else if (textLength > 9){

            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP ,18F)
        }
        else if (textLength > 8){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP ,14F)
        }
        else if (textLength > 7){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP ,10F)
        }
        else if (textLength > 6){
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP ,5F)
        }
        else if (textLength > 5){

        }
        else if (textLength > 4){

        }
        else if (textLength > 3){

        }
        else if (textLength > 2){

        }
        else if (textLength > 1){

        }


    }



    object VectorDrawableUtils {

        fun getDrawable(context: Context, drawableResId: Int): Drawable? {
            return VectorDrawableCompat.create(context.resources, drawableResId, context.theme)
        }

        fun getDrawable(context: Context, drawableResId: Int, colorFilter: Int): Drawable {
            val drawable = getDrawable(context, drawableResId)
            drawable!!.setColorFilter(colorFilter, PorterDuff.Mode.SRC_IN)
            return drawable
        }

        fun getBitmap(context: Context, drawableId: Int): Bitmap {
            val drawable = getDrawable(context, drawableId)

            val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            return bitmap
        }


    }




    fun setHeaderTitle( title:String ,view: TextView ){
        view.text = title

        if (view.length() > 17){
            view.text = view.text.substring(0,17)+"..."
        }
    }


}