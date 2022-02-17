package com.ivan.apptesis.ui.Lot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import com.ivan.apptesis.R

class LotFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_lot, container, false)
        val lotBtn: Button = root.findViewById(R.id.disp_lot_btn)
        val busquedaBtn: Button = root.findViewById(R.id.busqueda_material_btn)
        val estadisticaBtn: Button = root.findViewById(R.id.estadistica_btn)

        lotBtn.setOnClickListener(this)
        busquedaBtn.setOnClickListener(this)
        estadisticaBtn.setOnClickListener(this)

        return root
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.disp_lot_btn -> Toast.makeText(activity,getString(R.string.msj_lot),LENGTH_LONG).show()
            //R.id.busqueda_material_btn -> TODO lleva a busqueda de material en estanteria
            //R.id.estadistica_btn ->  TODO lleva a pantalla con info recolectanda de la biblioteca
        }
    }
}