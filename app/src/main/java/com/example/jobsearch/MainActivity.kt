package com.example.jobsearch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ui.screens.logIn.LogInScreen
import com.example.ui.theme.JobSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JobSearchTheme {
//                UiKitScreen()
//                UiKitMoleculesScreen()
                LogInScreen()
//                InstallAppNavGraph()
            }
        }
    }
}
