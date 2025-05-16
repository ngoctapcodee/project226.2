package com.uilover.project2262.Auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uilover.project2262.ViewModel.AuthViewModel

@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel()
) {
    val authState by authViewModel.authState.collectAsState()

    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Quên mật khẩu", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                authViewModel.resetPassword(email.trim())
                message = "Nếu email tồn tại, bạn sẽ nhận được link đặt lại mật khẩu"
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !authState.isLoading
        ) {
            Text(if (authState.isLoading) "Đang gửi..." else "Gửi link đặt lại mật khẩu")
        }

        Spacer(Modifier.height(8.dp))

        TextButton(onClick = { navController.popBackStack() }) {
            Text("Quay lại đăng nhập")
        }

        message?.let {
            Spacer(Modifier.height(16.dp))
            Text(text = it, color = MaterialTheme.colorScheme.primary)
        }

        authState.error?.let { error ->
            Spacer(Modifier.height(16.dp))
            Text(text = error, color = MaterialTheme.colorScheme.error)
            LaunchedEffect(error) {
                authViewModel.clearError()
            }
        }
    }
}
