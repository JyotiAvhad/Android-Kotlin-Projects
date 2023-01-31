package com.example.neostore.view.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.neostore.R
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.custom_tab_detail.*

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        btn_add_to_wishlist.setOnClickListener {
            val intent = Intent(this, WishListActivity::class.java)
            startActivity(intent)
        }

        iv_ic_menu.setOnClickListener {
            finish()
        }
    }
}