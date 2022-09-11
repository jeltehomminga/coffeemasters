package com.coffeefm.coffeeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coffeefm.coffeeexample.ui.theme.Alternative1
import com.coffeefm.coffeeexample.ui.theme.OnPrimary

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val MenuPage = NavPage("Menu", Icons.Outlined.Menu, "menu")
    val OffersPage = NavPage("Offers", Icons.Outlined.Star, "offers")
    val OrdersPage = NavPage("Orders", Icons.Outlined.ShoppingCart, "orders")
    val InfoPage = NavPage("Info", Icons.Outlined.Info, "info")

    val pages = listOf(MenuPage, OffersPage, OrdersPage, InfoPage)
}

@Preview
@Composable
fun NavBarItem_Preview() {
    NavBarItem(page = Routes.MenuPage, modifier = Modifier.padding(8.dp))
}

@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route, onChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,

        )
    {
        for (page in Routes.pages) {
            NavBarItem(
                modifier = Modifier.clickable {
                    onChange(page.route)
                },
                page,
                selected = selectedRoute == page.route,
            )
        }
    }
}

@Composable
fun NavBarItem(modifier: Modifier = Modifier, page: NavPage, selected: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(12.dp)) {
        Image(
            page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(if (selected) OnPrimary else Alternative1),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(text = page.name, color = if (selected) OnPrimary else Alternative1)
    }
}