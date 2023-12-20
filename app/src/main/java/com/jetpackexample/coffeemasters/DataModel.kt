package com.jetpackexample.coffeemasters

data class Product(var id: Int, var name: String, var price: Double, var image: String) {
    val imageUrl get() = "http://20.20.20.10:5257/api/images/${this.image}"
}


class Category(var name: String,var products: MutableList<Product>)

class ProductInCart(var product: Product,var quantity: Int)