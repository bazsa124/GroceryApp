package com.example.groceryapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.ui.DialogListener
import com.example.groceryapp.ui.GroceryItemDialog
import com.example.groceryapp.ui.GroceryViewModel

class GroceryAdapter(var context:Context, var list: List<GroceryItems>, private val viewModel: GroceryViewModel) :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemadapter, parent, false)
        return GroceryViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val currentPosition = list[position]
        holder.chBox.isChecked = currentPosition.itemCheck
        holder.txtItemName.text = currentPosition.itemName
        holder.txtItemType.text = currentPosition.itemType
        holder.txtItemQuantity.text = "${currentPosition.itemQuantity}"

        holder.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }

        holder.chBox.setOnCheckedChangeListener { _, isChecked ->
            currentPosition.itemCheck = isChecked
            viewModel.update(currentPosition)
        }

        holder.ibMod.setOnClickListener{
            GroceryItemDialog(context, object : DialogListener {
                override fun onAddButtonClicked(item: GroceryItems) {
                    currentPosition.itemName=item.itemName
                    currentPosition.itemQuantity=item.itemQuantity
                    currentPosition.itemType=item.itemType
                    viewModel.update(currentPosition)

                }
            },currentPosition).show()
        }
    }

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chBox:CheckBox=itemView.findViewById(R.id.checkBox)
        val txtItemName: TextView = itemView.findViewById(R.id.txtItemName)
        val txtItemType: TextView = itemView.findViewById(R.id.txtItemPrice)
        val txtItemQuantity: TextView = itemView.findViewById(R.id.txtItemQuantity)
        val ibDelete: ImageButton = itemView.findViewById(R.id.ibDelete)
        val ibMod: ImageButton = itemView.findViewById(R.id.ibMod)
    }
}