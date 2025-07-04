package com.apphico.codechallenge2.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToWelcomeScreen: (String) -> Unit
) {
    val user = loginViewModel.user.collectAsState()
    val isUserLogged by loginViewModel.isUserLogged.collectAsState()

    LaunchedEffect(isUserLogged) {
        if(isUserLogged)  navigateToWelcomeScreen(user.value.userName)
    }

    LoginScreenContent(
        user = user,
        onUserNameChange = loginViewModel::onUserNameChange,
        onPasswordChange = loginViewModel::onPasswordChange,
        onLoginClick = loginViewModel::login
    )
}

@Composable
fun LoginScreenContent(
    user: State<User>,
    onUserNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = user.value.userName,
            onValueChange = onUserNameChange,
            label = { Text("Username") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = user.value.password,
            onValueChange = onPasswordChange,
            label = { Text("Password") }
        )
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = onLoginClick
        ) {
            Text("Login")
        }
    }
}

@Preview
@Composable
fun LoginScreenContentPreview(

) {
    LoginScreenContent(
        user = remember { mutableStateOf(User("guilherme", "123456")) },
        onUserNameChange = {},
        onPasswordChange = {},
        onLoginClick = {}
    )
}