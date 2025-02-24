package br.giovannimontanari.composematerial3.components.bottomAppBar

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.giovannimontanari.composematerial3.navigation.host.BottomAppBarHost
import br.giovannimontanari.composematerial3.navigation.item.BottomNavItem
import br.giovannimontanari.composematerial3.navigation.routes.BottomAppBarRoutes

@Composable
fun MyBottomAppBar(
    navHostController: NavHostController
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    BottomNavItem.items.forEach { item ->
                        NavItem(
                            item = item,
                            currentDestination = currentDestination,
                            navHostController = navHostController
                        )
                    }
                },
                modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                containerColor = Color.White
            )
        },
        containerColor = Color(0xFFd6fdd3),
    ) { innerPadding ->
        BottomAppBarHost(
            modifier = Modifier.padding(innerPadding),
            navController = navHostController,
            startDestination = BottomAppBarRoutes.Feed.route
        )
    }
}