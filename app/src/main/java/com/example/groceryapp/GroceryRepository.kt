package com.example.groceryapp

class GroceryRepository(private val db: GroceryDatabase) {

    suspend fun insert(item: GroceryItems) = db.getGroceryDao().insert(item)
    suspend fun delete(item: GroceryItems) = db.getGroceryDao().delete(item)
    suspend fun update(item:GroceryItems) =db.getGroceryDao().update(item)

    fun allGroceryItems() = db.getGroceryDao().getAllGroceryItems()
}