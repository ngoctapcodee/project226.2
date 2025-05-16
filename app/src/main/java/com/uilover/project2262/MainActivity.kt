package com.uilover.project2262

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uilover.project2262.Activities.Splash.SplashActivity
import com.uilover.project2262.Auth.LoginScreen
import com.uilover.project2262.Auth.RegisterScreen
import com.uilover.project2262.ViewModel.AuthViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    val authViewModel: AuthViewModel = viewModel()

                    NavHost(navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(navController, authViewModel) {
                                // onLoginSuccess -> mở SplashActivity
                                startActivity(Intent(this@MainActivity, SplashActivity::class.java))
                                finish()
                            }
                        }
                        composable("register") {
                            RegisterScreen(navController, authViewModel) {
                                startActivity(Intent(this@MainActivity, SplashActivity::class.java))
                                finish()
                            }
                        }
//                        composable("forgot_password") {
//                            ForgotPasswordScreen(navController, authViewModel)
//                        }
                    }
                }
            }
        }
    }
}
