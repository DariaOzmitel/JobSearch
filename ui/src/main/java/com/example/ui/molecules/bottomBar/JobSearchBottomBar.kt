package com.example.ui.molecules.bottomBar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.ui.elements.text.TabText
import com.example.ui.navigation.BottomNavigationItem
import com.example.ui.navigation.NavigationState

@Composable
internal fun JobSearchBottomBar(
    modifier: Modifier = Modifier,
    navBackStackEntry: NavBackStackEntry?,
    navigationState: NavigationState
) {
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.Transparent
    ) {
        BottomNavigationItem.entries.forEach { item ->
            val isSelected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navigationState.navigateTo(item.screen.route)
                    }
                },
                icon = {
                    Column {
                        Icon(
                            painter = painterResource(id = item.iconResId),
                            contentDescription = item.name
                        )
                    }
                },
                label = { TabText(text = stringResource(id = item.titleResId)) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}