package com.ivan.apptesis

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.ivan.apptesis.ui.DialogLoginActivity
import kotlinx.android.synthetic.main.custom_dialog_login.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navloginBtn: Button
    lateinit var navImage: ImageView
    lateinit var navUser: TextView
    lateinit var navAccount: TextView
    lateinit var linearGroup: LinearLayout

    //Variables de prueba para inicio de sesion
    val usuario: String="NOMBRE APELLIDO"
    val cuenta : String= "example@example.com.mx"
    val usrImgRes: Int = R.drawable.usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Servicio de mensajeria entre usuario y biblioteca", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_catalogo,
                R.id.nav_localizacion,
                R.id.nav_contacto,
                R.id.nav_historia,
                R.id.nav_servicios,
                R.id.nav_tutoriales,
                R.id.nav_eventos,
                R.id.nav_directorio,
                R.id.nav_lot
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val headerView: View = navView.getHeaderView(0)
        navloginBtn = headerView.findViewById<View>(R.id.loginBtn) as Button
        navImage = headerView.findViewById<View>(R.id.navImageUser) as ImageView
        navUser = headerView.findViewById<View>(R.id.navUser) as TextView
        navAccount = headerView.findViewById<View>(R.id.navAccount) as TextView
        linearGroup = headerView.findViewById<View>(R.id.dataGroup) as LinearLayout
        navloginBtn.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onClick(p0: View?) {
        showPopUp()
    }

    fun showPopUp() {
        val intent = Intent(this, DialogLoginActivity::class.java)
        //Simula el inicio de sesion
        if( (navloginBtn.text.equals("INICIO SESIÓN"))){

            startActivityForResult(intent,1)
        }
        else{
            linearGroup.setVisibility(View.GONE)
            navImage.setImageDrawable(getDrawable(R.mipmap.ic_launcher_round))
            navloginBtn.setText("INICIO SESIÓN")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        navloginBtn.setText("CERRAR SESIÓN")
        linearGroup.setVisibility(View.VISIBLE)
        navUser.setText(usuario)
        navAccount.setText(cuenta)
        navImage.setImageDrawable(null)
        navImage.setImageDrawable(getDrawable(usrImgRes))
    }
}