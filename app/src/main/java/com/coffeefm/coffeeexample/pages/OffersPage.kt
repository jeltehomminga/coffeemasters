package com.coffeefm.coffeeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coffeefm.coffeeexample.ui.theme.Alternative1
import com.coffeefm.coffeeexample.ui.theme.Alternative2

@Preview(showBackground = true, widthDp = 400)
@Composable
private fun Offer_Preview() {
    Offer(title = "My title 1", description = "My description")
}

@Preview(showBackground = true)
@Composable
fun OfferPage() {
    Column(
        Modifier.verticalScroll((rememberScrollState()))
    ) {
        Offer(title = "Early Coffee", description = "10% offer, Offer only valid in the morning")
        Offer(title = "New Offer", description = "late evening brunch discount")
        Offer(title = "Buy 1 get 4", description = "Unbelievable discount, drink 4 and only pay for one coffee")
    }
}


@Composable
fun Offer(title: String, description: String) {
    Box(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.background_pattern),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .background(color = Alternative1)
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .background(color = Alternative2)
                    .padding(16.dp)
            )
        }
    }
}