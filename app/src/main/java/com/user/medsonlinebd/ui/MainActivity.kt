package com.user.medsonlinebd.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.dana.money.data.SPreferences
import com.mindorks.retrofit.coroutines.utils.Status
import com.user.medsonlinebd.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        Handler().postDelayed({

            mainViewModel.getUsers().observe(this, Observer {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            progressBar.visibility = View.GONE
                            resource.data?.let { users -> Toast.makeText(applicationContext,users.toString(),Toast.LENGTH_SHORT).show() }
                        }
                        Status.ERROR -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                        }
                        Status.LOADING -> {
                            progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            })

        }, 5000)










    }
}