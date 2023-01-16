package com.example.neostore.view.activities

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neostore.R
import com.example.neostore.view.adapter.WishlistAdapter
import com.example.neostore.view.model.ProductWishListModel
import kotlinx.android.synthetic.main.activity_wish_list.*
import kotlinx.android.synthetic.main.custom_tab_wishlist.*

class WishListActivity : AppCompatActivity() {

    private val prodItemWishList = ArrayList<ProductWishListModel>()
    private lateinit var wishlistAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wish_list)

        //product list on home fragment
        var price = 100.2
        for (i in 'A'..'Z') {
            prodItemWishList.add(
                ProductWishListModel(
                    R.drawable.ic_home_24px,
                    "$i",
                    price.toFloat()
                )
            )
        }
        rv_card_wishlist.layoutManager = GridLayoutManager(this, 2)
        wishlistAdapter = WishlistAdapter(prodItemWishList)
        rv_card_wishlist.adapter = wishlistAdapter

        iv_ic_menu.setOnClickListener {
            finish()
        }

    }

}
