package com.example.ezetap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        var intent=intent
        val user=intent.getStringArrayExtra("user")
        val password=intent.getStringArrayExtra("password")
        val email=intent.getStringArrayExtra("email")
        val birth=intent.getStringArrayExtra("birth")
        val  resultTv=findViewById<TextView>(R.id.textView)
        resultTv.text="UserName"+user
        val  resultTvT=findViewById<TextView>(R.id.textView2)
        resultTvT.text="Password"+password
        val  resultTvTr=findViewById<TextView>(R.id.textView3)
        resultTvTr.text="Password"+email
        val  resultTvF=findViewById<TextView>(R.id.textView4)
        resultTvT.text="Password"+birth

        findViewById<Button>(R.id.btnHome).setOnClickListener {
            val intento= Intent(this,HomeActivity::class.java)
            startActivity(intento)

        }


    }
}