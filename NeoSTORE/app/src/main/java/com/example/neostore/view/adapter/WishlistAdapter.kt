package com.example.neostore.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.neostore.R
import com.example.neostore.view.activities.WishListActivity
import com.example.neostore.view.model.ProductWishListModel
import kotlinx.android.synthetic.main.item_wishlist_layout.view.*


class WishlistAdapter(var wNameList: List<ProductWishListModel>) :
    RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_wishlist_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val productListModel = wNameList[position]
        holder.productImg.setImageResource(productListModel.wImage)
        holder.productName.text = productListModel.wName
        holder.productPrice.text = productListModel.wPrice.toString()


    }

    override fun getItemCount(): Int {
        return wNameList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productImg: ImageView = itemView.iv_product_img
        var productName: TextView = itemView.tv_product_name
        var productPrice: TextView = itemView.tv_product_price
        var moveToBag: AppCompatButton = itemView.btn_move_to_bag

        init {
            moveToBag.setOnClickListener {
                Toast.makeText(itemView.context,"Item Added Successfully...:-)",Toast.LENGTH_SHORT).show()
            }
        }
    }


}


