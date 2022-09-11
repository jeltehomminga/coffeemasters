package com.coffeefm.coffeeexample.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.coffeefm.coffeeexample.DataManager
import com.coffeefm.coffeeexample.Product
import com.coffeefm.coffeeexample.ui.theme.CardBackground
import com.coffeefm.coffeeexample.ui.theme.Primary

@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn {

        items(dataManager.menu) {
            Text(
                it.name,
                color = Primary,
                modifier = Modifier.padding(16.dp),
            )
            it.products.forEach {
                Card(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                ) {
                    ProductItem(product = it, onAdd = { product ->
                        dataManager.cartAdd(product)
                    })

                }
            }
        }
    }
}



fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column() {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = "${product.price.format(2)} €")
            }
            Button(onClick = { onAdd(product) }) {
                Text(text = "Add")
            }
        }
    }
}
