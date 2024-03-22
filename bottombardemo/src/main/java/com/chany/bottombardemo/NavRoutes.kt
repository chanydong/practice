package com.chany.bottombardemo

sealed class NavRoutes(val route: String) {
    object Home: NavRoutes("home")
    object Contacts: NavRoutes("contacts")
    object Favorites: NavRoutes("favorites")
}