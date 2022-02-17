package com.ivan.apptesis.ui.catalogo

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnAttachStateChangeListener
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import com.ivan.apptesis.R
import java.util.*


class CatalogoFragment() : Fragment() {

    var recipeList: MutableList<String> =ArrayList()
    var recipeListDB: MutableList<String> =ArrayList()

    constructor( filteredNewsList: MutableList<String>) : this() {
    this.recipeList =filteredNewsList
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)

        recipeListDB.add("Lunes")
        recipeListDB.add("Martes")
        recipeListDB.add("Miercoles")
        recipeListDB.add("Jueves")
        recipeListDB.add("Viernes")
        recipeListDB.add("Sabado")
        recipeListDB.add("Domingo")

        if(recipeList.isEmpty()){
            recipeList=recipeListDB;
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_catalogo, container, false)
        val searchView : SearchView = root.findViewById(R.id.search_catalogo) as SearchView
        val listView : ListView = root.findViewById(R.id.results_catalogo) as ListView
        val spinnerView: Spinner = root.findViewById(R.id.spinner_opciones)
        val a = activity
        var adapter = ArrayAdapter(a!!.baseContext, android.R.layout.simple_list_item_1, recipeList)

        if (a != null) {
            val arrayAdapter=    ArrayAdapter.createFromResource(
                a.baseContext,
                R.array.opciones_busqueda_array,
                android.R.layout.simple_spinner_item
            )
            spinnerView.adapter= arrayAdapter
        }

        searchView.setOnClickListener(View.OnClickListener { searchView.setIconified(false)
            adapter = ArrayAdapter(a!!.baseContext, android.R.layout.simple_list_item_1, recipeListDB)
            listView.adapter = adapter})
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {

                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                searchCard(query)
                return false
            }
        })

        listView.adapter = adapter
        return root
    }


    fun searchCard(query: String) {
        val filteredNewsList: MutableList<String> = ArrayList()
        for ((posicion, valor) in recipeListDB.withIndex()) {
            if (recipeListDB.get(posicion).toLowerCase().contains(query.toLowerCase())) {
                filteredNewsList.add(valor)
                Log.e("JOHN","$valor")
            }
        }
        fragmentManager!!.beginTransaction().replace(R.id.nav_host_fragment,  CatalogoFragment(filteredNewsList), "ok").commit()
    }
}