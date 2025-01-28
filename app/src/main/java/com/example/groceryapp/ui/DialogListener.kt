package com.example.groceryapp.ui

import com.example.groceryapp.GroceryItems


interface DialogListener {
    fun onAddButtonClicked(item: GroceryItems)
}