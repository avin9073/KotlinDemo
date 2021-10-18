package com.example.privatelyurs.model.entity

data class WishlistItem_List(
   // val Item_id: Int,
    val Item_image_url: Int,
    val Item_name: String,
    val Item_Old_Price:String,
    val Item_Price:String,
    val Item_Discount: String
)

data class ProductItem_List(
    // val Item_id: Int,
    val Item_image_url: Int,
    val Item_name: String,
    val Item_Old_Price:String,
    val Item_Price:String,
    val Item_Discount: String
)


data class OrderItem_List(

    val Item_image_url: Int,
    val Item_Delivery: String,
    val Item_name: String,
    val Item_Old_Price:String,
    val Item_Price:String

)

data class CategoryItem_List(
    // val Item_id: Int,
    val Item_image_url: Int,
    val Item_name: String

)

data class HomeItem_List(
    // val Item_id: Int,
    val Item_image_url: Int,
    val Item_name: String
)

data class HomeSingleItem_List(
    // val Item_id: Int,
    val Item_image_url: Int,
    val Item_name: String,
    val Item_Old_Price:String,
    val Item_Price:String,
    val Item_Discount: String
)

data class AddressBook_List(
    // val Item_id: Int,
    val Name: String,
    val Address: String
)