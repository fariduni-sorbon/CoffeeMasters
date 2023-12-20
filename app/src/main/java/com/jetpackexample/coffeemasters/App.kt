package com.jetpackexample.coffeemasters

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jetpackexample.coffeemasters.pages.InfoPage
import com.jetpackexample.coffeemasters.pages.MenuPage
import com.jetpackexample.coffeemasters.pages.OffersPage
import com.jetpackexample.coffeemasters.pages.OrderPage


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(dataManager: DataManager) {
    var selectedRoute = remember {
        mutableStateOf(Routes.MenuPage.route)
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            AppTitle()
        })
    }, bottomBar = {
        NavBar(selectedRoute = selectedRoute.value, onChange = { newRoute ->
            selectedRoute.value = newRoute
        })
    }) {
        when (selectedRoute.value) {
            Routes.MenuPage.route -> MenuPage(dataManager,
                modifier = Modifier.padding(
                    top = 64.dp,
                    bottom = 64.dp
                )
            )

            Routes.OffersPage.route -> OffersPage(
                modifier = Modifier.padding(
                    top = 64.dp,
                    bottom = 64.dp
                )
            )

            Routes.OrderPage.route -> OrderPage(dataManager,
                modifier = Modifier.padding(
                    top = 64.dp,
                    bottom = 64.dp
                )
            )

            Routes.InfoPage.route -> InfoPage(
                modifier = Modifier.padding(
                    top = 64.dp,
                    bottom = 64.dp
                )
            )
        }
    }

}

@Composable
fun AppTitle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.primary), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Coffee Masters logo"
        )
    }
}