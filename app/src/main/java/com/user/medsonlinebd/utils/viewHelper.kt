package com.misfit.danaagent.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Build
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.user.medsonlinebd.MedsonlineBD


object viewHelper {


    //Notice bar white color
    fun setLightStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
            activity.window.statusBarColor = Color.WHITE
        }
    }

    fun White_transparentStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val w = activity.window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            val flags = view.systemUiVisibility
            //flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.systemUiVisibility = flags
        }
    }

    fun transparentStatusBar(view: View, activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val w = activity.window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            var flags = view.systemUiVisibility
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            view.systemUiVisibility = flags
        }
    }


    fun blinkItem(itemView: View) {
        itemView.visibility = View.INVISIBLE
        val handler = Handler()
        handler.postDelayed({ itemView.visibility = View.VISIBLE }, 100)

    }


    fun showToast(message: String?) {
        Toast.makeText(MedsonlineBD.instance, message, Toast.LENGTH_SHORT).show()
    }

    fun confirmationDialog(
        context: Context,
        title: String?,
        description: String?,
        confirmDialogListener: ConfirmDialogListener
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(description)
        builder.setPositiveButton("YES") { dialog, which ->
            confirmDialogListener.onPositiveButtonSelect(dialog)
        }
        builder.setNegativeButton("NO") { dialog, which ->
            dialog.dismiss()
        }
        val alert: AlertDialog = builder.create()
        alert.show()

    }

    interface ConfirmDialogListener {
        fun onPositiveButtonSelect(dialog: DialogInterface)
    }

}