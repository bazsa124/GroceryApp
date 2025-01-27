package com.example.groceryapp.ui

import com.example.groceryapp.GroceryItems


interface DialogListener {

    // Create a function to add items
    // in GroceryItems on clicking
    fun onAddButtonClicked(item: GroceryItems)
}