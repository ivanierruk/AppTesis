package com.ivan.apptesis.ui.Eventos

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ivan.apptesis.R


class EventosFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_eventos, container, false)

        val textView: TextView = root!!.findViewById(R.id.txt_tuto)
        val textEvent= "¡¡¡TesseracT se reprograma para el 5 de abril 2022!!!\n" +
                "Por cuestiones ya sabidas a nivel mundial, el show que estaba programado para el 14 de marzo de este año de la banda británica #Tesseract se pospone para el 2022.\n" +
                "Los boletos son válidos para esta fecha. El reembolso se podrá realizar hasta que se puedan abrir las taquillas y centros Ticketmaster México.\n" +
                "¡Gracias por tu apoyo y paciencia!\n" +
                "¡Nos vemos en 2022! <a href=https://www.google.com/search?q=eventos+biblioteca&sxsrf=AOaemvJX3MnQ5vx7KUF-3bVr2vATLz2v3w:1642713324629&ei=7NDpYfvxJdjFhwOLhZzYDQ&uact=5&oq=eventos+biblioteca&gs_lcp=Cgdnd3Mtd2l6EAMyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeOgcIABBHELADOgUIABDLAToECAAQQ0oECEEYAEoECEYYAFD7A1izGmDkG2gBcAB4AIAB6gGIAe4LkgEFMC43LjOYAQCgAQHIAQjAAQE&sclient=gws-wiz&ibp=htl;events&rciv=evn&sa=X&ved=2ahUKEwienJ2HoMH1AhWHJ0QIHf9eA7cQ5bwDegQIBRAB#fpstate=tldetail&htidocid=L2F1dGhvcml0eS9ob3Jpem9uL2NsdXN0ZXJlZF9ldmVudC8yMDIyLTA0LTA1fF82NTgwNTE4NzE0MTIzMDMzMzEx&htivrt=events&mid=/g/11n_yfx_50>Click</a>"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(textEvent, Html.FROM_HTML_MODE_LEGACY))
        } else {
            textView.setText(Html.fromHtml(textEvent))
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance())
        textView.setClickable(true)
        return root
    }
}