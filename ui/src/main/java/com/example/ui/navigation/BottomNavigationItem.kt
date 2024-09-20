package com.example.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ui.R

enum class BottomNavigationItem(
    val screen: Screen,
    @DrawableRes val iconResId: Int,
    @StringRes val titleResId: Int
) {
    Search(screen = Screen.Search, iconResId = R.drawable.search, titleResId = R.string.search),
    Favorites(
        screen = Screen.Favorites,
        iconResId = R.drawable.favorites,
        titleResId = R.string.favorites
    ),
    Responses(
        screen = Screen.Responses,
        iconResId = R.drawable.responses,
        titleResId = R.string.responses
    ),
    Messages(
        screen = Screen.Messages,
        iconResId = R.drawable.messages,
        titleResId = R.string.messages
    ),
    Profile(screen = Screen.Profile, iconResId = R.drawable.profile, titleResId = R.string.profile),
}