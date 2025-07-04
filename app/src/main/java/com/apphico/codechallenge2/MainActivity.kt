package com.apphico.codechallenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apphico.codechallenge2.ui.login.LoginScreen
import com.apphico.codechallenge2.ui.login.LoginViewModel
import com.apphico.codechallenge2.ui.theme.CodeChallenge2Theme
import com.apphico.codechallenge2.ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            CodeChallenge2Theme {
                val navController = rememberNavController()

                val welcomeRoute = "welcome_screen_route/{userName}"

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding.calculateTopPadding()

                    // TODO Create routes in a separate file and also the graph
                    NavHost(
                        navController = navController,
                        startDestination = "login_screen_route",
                    ) {
                        composable("login_screen_route") {
                            LoginScreen(
                                // TODO User type safe navigation
                                navigateToWelcomeScreen = { userName -> navController.navigate(welcomeRoute.replace("{userName}", userName)) }
                            )
                        }
                        composable(welcomeRoute) { backStackEntry ->
                            val userName = backStackEntry.arguments?.getString("userName")
                            WelcomeScreen(
                                userName = userName
                            )
                        }
                    }
                }
            }
        }
    }
}