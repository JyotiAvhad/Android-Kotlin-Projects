package com.example.neostore.view.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neostore.R
import com.example.neostore.view.RecyclerGridAdapter
import kotlinx.android.synthetic.main.categories_list_layout.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val prodItemList = ArrayList<ProductListModel>()
    private lateinit var recyclerGridAdapter: RecyclerGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //product list on home fragment
        var price = 50.2
        for (i in 'A'..'Z') {
            prodItemList.add(ProductListModel(R.drawable.ic_home_24px, "$i",price.toFloat()))
        }
        rv_card_list.layoutManager = GridLayoutManager(activity,2 )
        recyclerGridAdapter = RecyclerGridAdapter(prodItemList)
        rv_card_list.adapter = recyclerGridAdapter


    }


}