package com.jetpackexample.coffeemasters.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jetpackexample.coffeemasters.DataManager
import com.jetpackexample.coffeemasters.Product
import com.jetpackexample.coffeemasters.ui.theme.Alternative1
import com.jetpackexample.coffeemasters.ui.theme.CardBackground
import com.jetpackexample.coffeemasters.ui.theme.Primary

fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun MenuPage(dataManager: DataManager, modifier: Modifier) {
    LazyColumn(modifier = modifier) {
        items(dataManager.menu) {
            Text(it.name, color= Primary, modifier= Modifier.padding(10.dp,20.dp,10.dp,10.dp))
            it.products.forEach {
                Card(
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                ) {
                    ProductItem(it, onAdd = {
                        dataManager.cartAdd(it);
                    })

                }
            }
        }
    }
}


@Composable
fun ProductItem(product: Product, onAdd: (Product) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = "$${product.price.format(2)}")
            }
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = Alternative1,
                contentColor = Color.White
            ), onClick = { onAdd(product) }) {
                Text(text = "Add")
            }
        }
    }
}