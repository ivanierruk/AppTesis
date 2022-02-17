package com.ivan.apptesis.ui.Contacto

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.ivan.apptesis.R


class ContactoFragment : Fragment(),View.OnClickListener {
    //Target url`s from imgaeButtons
 val urlFacebook="https://www.facebook.com/"
 val urlTwitter="https://twitter.com/"
 val urlInstagram="https://www.instagram.com/"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contacto, container, false)
        val imageBtn1: ImageView = root.findViewById(R.id.sm_btn_fb)
        val imageBtn2: ImageView = root.findViewById(R.id.sm_btn_insta)
        val imageBtn3: ImageView = root.findViewById(R.id.sm_btn_twitter)

        imageBtn1.setOnClickListener(this)
        imageBtn2.setOnClickListener(this)
        imageBtn3.setOnClickListener(this)
        return root
    }

    override fun onClick(p0: View?) {
        var url = ""
        val i = Intent(Intent.ACTION_VIEW)
        when (p0?.id) {
            R.id.sm_btn_fb -> url =urlFacebook
            R.id.sm_btn_insta -> url =urlInstagram
            R.id.sm_btn_twitter -> url =urlTwitter
        }
        i.data = Uri.parse(url)
        startActivity(i)
    }
}