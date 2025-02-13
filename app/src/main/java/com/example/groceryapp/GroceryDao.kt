package com.example.groceryapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GroceryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: GroceryItems)

    @Delete
    suspend fun delete(item: GroceryItems)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: GroceryItems)

    @Query("SELECT * FROM grocery_items")
    fun getAllGroceryItems(): LiveData<List<GroceryItems>>
}