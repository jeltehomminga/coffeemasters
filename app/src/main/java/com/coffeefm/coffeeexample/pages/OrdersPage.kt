package com.coffeefm.coffeeexample.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.coffeefm.coffeeexample.DataManager
import com.coffeefm.coffeeexample.ItemInCart
import com.coffeefm.coffeeexample.Product
import com.coffeefm.coffeeexample.ui.theme.Primary

@Composable
fun OrdersPage(dataManager: DataManager) {
    if (dataManager.cart.isEmpty()) {
        Text(
            text = "No items in cart",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
    LazyColumn() {
        items(dataManager.cart) {
            CartItem(it = it, onDelete = { product ->
                dataManager.cardRemove(product)
            })
        }
    }
}


@Composable
fun CartItem(it: ItemInCart, onDelete: (Product) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(text = "${it.quantity}x")
        Text(text = it.product.name)
        Text(text = "${(it.quantity * it.product.price).format(2)}")
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            }
        )
    }

}
