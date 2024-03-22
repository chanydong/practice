package com.chany.bottombardemo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home

object NavBarItems {
    val barItems = listOf<BarItem>(
        BarItem(
            "Home",
            image = Icons.Filled.Home,
            "home"
        ),
        BarItem(
            "Contacts",
            image = Icons.Filled.Face,
            "contacts"
        ),
        BarItem(
            "Favorites",
            Icons.Filled.Favorite,
            "favorites"
        )
    )
}