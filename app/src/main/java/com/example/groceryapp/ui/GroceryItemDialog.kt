package com.example.groceryapp.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.groceryapp.R
import com.example.groceryapp.GroceryItems


class GroceryItemDialog(context: Context, var dialogListener: DialogListener, var item:GroceryItems?=null) : AppCompatDialog(context) {
    lateinit var etItemName : EditText
    lateinit var etItemQuantity : EditText
    lateinit var etItemType : EditText
    lateinit var tvSave : TextView
    lateinit var tvCancel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog)
        etItemName = findViewById(R.id.etItemName)!!
        etItemQuantity = findViewById(R.id.etItemQuantity)!!
        etItemType = findViewById(R.id.etItemPrice)!!
        tvSave = findViewById(R.id.tvSave)!!
        tvCancel = findViewById(R.id.tvCancel)!!

        if(item!=null){
            etItemName.text= Editable.Factory.getInstance().newEditable(item!!.itemName)
            etItemQuantity.text= Editable.Factory.getInstance().newEditable(item!!.itemQuantity.toString())
            etItemType.text= Editable.Factory.getInstance().newEditable(item!!.itemType)
        }

        tvSave.setOnClickListener {
        var quantity:Int=1
        var iType:String="db"
            val name = etItemName.text.toString()
            if (etItemQuantity.text.toString()!="")
                quantity = etItemQuantity.text.toString().toInt()

            if (etItemType.text.toString()!="")
                iType = etItemType.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(context, "Please Enter Item Name", Toast.LENGTH_SHORT).show()
            }
            val item = GroceryItems(false,name, quantity, iType)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}