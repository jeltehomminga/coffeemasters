package com.coffeefm.coffeeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.coffeefm.coffeeexample.ui.theme.CoffeeMastersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dataManager = ViewModelProvider(this).get(DataManager::class.java)
        setContent {
            CoffeeMastersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App(dataManager)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstComposable() {
    val name = remember {
        mutableStateOf("Coffee Masters")
    } // remember is a function that will remember the value of the variable even if the composable is recreated
    Column {
        Text(
            text = "Hello ${name.value}",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(16.dp),
            textAlign = TextAlign.Center
        )
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondComposable() {
    Column(modifier = Modifier
        .width(200.dp)
        .height(200.dp)
        .background(Color.Red)) {
        Text("Starla",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Green)
                .fillMaxWidth()
                .padding(16.dp)
                , textAlign = TextAlign.Center)
        Text("Tours",
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Black)
                .padding(16.dp), color = Color.White, )

    }
}