package com.ivan.apptesis.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.ivan.apptesis.R

class DialogLoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog_login)
        getActionBar()?.hide()
        val urs_txt = findViewById<EditText>(R.id.usr_txt)
        val psw_txt = findViewById<EditText>(R.id.psw_txt)
        val login_btn = findViewById<Button>(R.id.login_btn)
        login_btn.setOnClickListener(View.OnClickListener {
finish()
        })
    }
}