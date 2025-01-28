package com.example.groceryapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.random.Random

@Entity(tableName = "grocery_items")

data class GroceryItems(

    @ColumnInfo(name="itemCheck")
    var itemCheck:Boolean,

    @ColumnInfo(name = "itemName")
    var itemName: String,

    @ColumnInfo(name = "itemQuantity")
    var itemQuantity: Int,

    @ColumnInfo(name = "itemType", defaultValue = "db")
    var itemType: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int?=Random.nextInt(0,10000)
}