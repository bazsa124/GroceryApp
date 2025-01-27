package com.example.groceryapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

// This is a data class which store data.
// Entities class create a table in database,
// in our database we will create three column

@Entity(tableName = "grocery_items")

data class GroceryItems(
    // create itemName variable to
    // store grocery items.


    @ColumnInfo(name="itemCheck")
    var itemCheck:Boolean,

    @ColumnInfo(name = "itemName")
    var itemName: String,

    // create itemQuantity variable
    // to store grocery quantity.
    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    // create itemPrice variable to
    // store grocery price.
    @ColumnInfo(name = "itemType", defaultValue = "db")
    var itemType: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int?=Random.nextInt(0,10000)
}