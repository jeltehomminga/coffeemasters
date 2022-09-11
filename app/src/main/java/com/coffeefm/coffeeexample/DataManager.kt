package com.coffeefm.coffeeexample

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataManager(app: Application) : AndroidViewModel(app){
    var menu :  List<Category> by mutableStateOf(listOf())
    var cart :  List<ItemInCart> by mutableStateOf(listOf())

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
        }
    }

    fun cartAdd(product: Product){
        var found = false
        cart.forEach {
            if(it.product.id == product.id){
                it.quantity++
                found = true
            }
        }
        if(!found){
            cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
        }
    }
    fun cartClear(){
        cart = listOf()
    }
    fun cardRemove(product: Product){
        cart = cart.filter { it.product.id != product.id }
    }
}