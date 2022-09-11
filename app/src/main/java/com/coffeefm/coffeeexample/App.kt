package com.coffeefm.coffeeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.coffeefm.coffeeexample.pages.InfoPage
import com.coffeefm.coffeeexample.pages.MenuPage
import com.coffeefm.coffeeexample.pages.OrdersPage
import com.coffeefm.coffeeexample.ui.theme.CoffeeMastersTheme

//@Preview
//@Composable
//fun App_Previews() {
//    CoffeeMastersTheme() {
//        App()
//    }
//}

@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember { mutableStateOf(Routes.MenuPage.route) }
    Scaffold(topBar = {
        TopAppBar() {
            AppTitle()
        }

    }, bottomBar = {
        NavBar(selectedRoute.value, onChange = { newRoute ->
            selectedRoute.value = newRoute
        })
    }) {
            when (selectedRoute.value) {
                Routes.OffersPage.route -> OfferPage()
                Routes.MenuPage.route -> MenuPage(dataManager)
                Routes.OrdersPage.route -> OrdersPage(dataManager)
                Routes.InfoPage.route -> InfoPage()
            }
        }
    }

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "coffee masters logo"
        )
    }
}