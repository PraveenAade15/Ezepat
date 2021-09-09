package com.example.ezetap

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class AddressActivity : AppCompatActivity() {
  lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        val address=findViewById<TextView>(R.id.tvAddressText)
        val saveAdd=findViewById<Button>(R.id.btnSaveLoc)


        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)

        findViewById<Button>(R.id.btnLocation).setOnClickListener {
            fetchLocation()
        }
        saveAdd.setOnClickListener {
            val intent= Intent(this,ShowActivity::class.java)
            intent.putExtra("add",localClassName)
            startActivity(intent)
        }


    }

    private fun fetchLocation() {
        val task=fusedLocationProviderClient.lastLocation
       if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_DENIED && ActivityCompat
                       .checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){

ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),101)
           return
        }
        task.addOnSuccessListener {
            if (it!=null){
              Toast.makeText(applicationContext,"${it.latitude}${it.longitude}",Toast.LENGTH_SHORT).show()
            }
        }

    }
}