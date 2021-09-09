package com.example.ezetap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userName=findViewById<EditText>(R.id.etUserName)
        val password=findViewById<EditText>(R.id.etPassword)
        val email=findViewById<EditText>(R.id.etEmail)
        val birthday=findViewById<EditText>(R.id.etBirthday)
        val save=findViewById<Button>(R.id.btnSave)
        save.setOnClickListener {
            var user=userName.text.toString()
            var emailId=email.text.toString()
            var passwordNu=password.text.toString()
            var birth=birthday.text.toString().trim()
            if (user.isEmpty()){
                userName.error="Username Required"
                return@setOnClickListener
            }
            else if (passwordNu.isEmpty()){
                password.error="Password is required"
                return@setOnClickListener

            }
            else if (emailId.isEmpty()){
                email.error="Email is required"
                return@setOnClickListener

            }
            else if (birth.isEmpty()){
                birthday.error="BirthDay is required"
                return@setOnClickListener

            }
            val intent= Intent(this,ShowActivity::class.java)
            intent.putExtra("user",user)
            intent.putExtra("password",passwordNu)
            intent.putExtra("email",emailId)
            intent.putExtra("birth",birth)
            startActivity(intent)


        }


    }

}