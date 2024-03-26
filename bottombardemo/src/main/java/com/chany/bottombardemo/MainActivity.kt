package com.chany.bottombardemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.input.key.Key.Companion.SetTopBoxPower
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chany.bottombardemo.screens.Contacts
import com.chany.bottombardemo.screens.Favorites
import com.chany.bottombardemo.screens.Home
import com.chany.bottombardemo.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTest() {
    MainScreen()
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Bottom Navigation Demo") }) },
        bottomBar = { BottomNavigationBar(navController = navController)

    }) {
        paddingVAlue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingVAlue.calculateTopPadding(),
                    bottom = paddingVAlue.calculateBottomPadding()
                )
        ) {
            NavigationHost(navController = navController)
        }
    }

}

@Composable
fun NavigationHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoutes.Home.route,) {
        composable(NavRoutes.Home.route) {
            Home()
        }
        composable(NavRoutes.Contacts.route) {
            Contacts()
        }
        composable(NavRoutes.Favorites.route) {
            Favorites()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.barItems.forEach {
            navItem ->
            BottomNavigationItem(selected = currentRoute == navItem.route, onClick = {
                navController.navigate(navItem.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = {
                Icon(imageVector = navItem.image, contentDescription = navItem.title)},
                label = {
                    Text(navItem.title)
                }
            )
        }

    }



}
