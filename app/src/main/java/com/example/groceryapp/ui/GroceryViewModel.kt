package com.example.groceryapp.ui

import androidx.lifecycle.ViewModel
import com.example.groceryapp.GroceryItems
import com.example.groceryapp.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) : ViewModel() {

    fun insert(item: GroceryItems) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: GroceryItems) = GlobalScope.launch {
        repository.delete(item)
    }

    fun update(item:GroceryItems)=GlobalScope.launch {
        repository.update(item)
    }

    fun allGroceryItems() = repository.allGroceryItems()

}