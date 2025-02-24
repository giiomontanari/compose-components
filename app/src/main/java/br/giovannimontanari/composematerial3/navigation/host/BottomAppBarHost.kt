package br.giovannimontanari.composematerial3.navigation.host

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.giovannimontanari.composematerial3.components.Tabs.MyTabsUi
import br.giovannimontanari.composematerial3.features.feed.FeedScreen
import br.giovannimontanari.composematerial3.features.friends.FriendsScreen
import br.giovannimontanari.composematerial3.features.profile.ProfileScreen
import br.giovannimontanari.composematerial3.features.search.SearchScreen
import br.giovannimontanari.composematerial3.navigation.routes.BottomAppBarRoutes

@Composable
fun BottomAppBarHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String
) {

    NavHost(
        navController = navController, startDestination = startDestination,
        modifier = modifier
    ) {

        composable(route = BottomAppBarRoutes.Feed.route) {
            //MyTabsUi()
            FeedScreen()
        }
        composable(route = BottomAppBarRoutes.Search.route) {
            SearchScreen()
        }
        composable(route = BottomAppBarRoutes.Friends.route) {
            FriendsScreen()
        }
        composable(route = BottomAppBarRoutes.Profile.route) {
            ProfileScreen()
        }
    }
}
