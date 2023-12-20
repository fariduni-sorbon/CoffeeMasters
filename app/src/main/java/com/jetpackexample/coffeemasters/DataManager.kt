package com.jetpackexample.coffeemasters

import CoffeeMastersApiService
import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataManager(app: Application) : AndroidViewModel(app) {
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ProductInCart> by mutableStateOf(listOf())

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            menu = CoffeeMastersApiService.API.menuService.fetchMenu()
        }
    }

    fun cartAdd(product: Product) {
        var found = false
        cart.forEach {
            if (product.id == it.product.id) {
                it.quantity++
                found = true
            }

        }
        if (!found) {
            cart = listOf(*cart.toTypedArray(), ProductInCart(product, 1))

        }
    }

    fun cartClear() {
        cart = listOf()
    }

    fun cartRemove(product: Product) {
        val aux = cart.toMutableList()
        aux.removeAll { it.product.id == product.id }
        cart = listOf(*aux.toTypedArray())
    }
}
