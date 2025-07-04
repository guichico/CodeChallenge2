package com.apphico.codechallenge2.ui.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WelcomeScreen(
    userName: String?
) {
    // TODO Get name from saved state
    // val name = welcomeViewModel.name

    WelcomeScreenContent(
        name = userName
    )
}

@Composable
fun WelcomeScreenContent(
    name: String?
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text("Welcome, $name")
    }
}