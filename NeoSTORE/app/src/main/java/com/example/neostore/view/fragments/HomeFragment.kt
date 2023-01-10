package com.example.neostore.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.neostore.R
import com.example.neostore.view.RecyclerGridAdapter
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

        var price = 50.2
        prodItemList.clear()

        for (i in 'A'..'Z') {
//        for (i in 1..50) {
            prodItemList.add(ProductListModel(R.drawable.ic_home_24px, "$i",price.toFloat()))
        }
//        rv_card_list.setHasFixedSize(true)
        rv_card_list.layoutManager = GridLayoutManager(activity,2 )
//        rv_card_list.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerGridAdapter = RecyclerGridAdapter(prodItemList)
        rv_card_list.adapter = recyclerGridAdapter
//        recyclerGridAdapter.notifyDataSetChanged()


    }

}