package com.example.neostore.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.neostore.R
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        btn_get_started.setOnClickListener {
            val intent = Intent(this, LoginWithEmailActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}