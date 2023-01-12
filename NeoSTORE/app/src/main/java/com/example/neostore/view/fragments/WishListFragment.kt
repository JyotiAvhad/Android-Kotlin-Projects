package com.example.neostore.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neostore.R
import com.example.neostore.view.ProductWishListModel
import com.example.neostore.view.RecyclerGridAdapter
import com.example.neostore.view.WishlistAdapter
import kotlinx.android.synthetic.main.fragment_wish_list.*


class WishListFragment : Fragment() {

    private val prodItemWishList = ArrayList<ProductWishListModel>()
    private lateinit var wishlistAdapter: WishlistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wish_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //product list on home fragment
        var price = 100.2
        for (i in 'A'..'Z') {
            prodItemWishList.add(ProductWishListModel(R.drawable.ic_home_24px, "$i",price.toFloat()))
        }
        rv_card_wishlist.layoutManager = GridLayoutManager(activity,2 )
        wishlistAdapter = WishlistAdapter(prodItemWishList)
        rv_card_wishlist.adapter = wishlistAdapter

    }

}