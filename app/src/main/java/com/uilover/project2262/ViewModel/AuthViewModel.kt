package com.uilover.project2262.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class AuthUiState(
    val isLoading: Boolean = false,
    val userId: String? = null,
    val error: String? = null
)

class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    internal val _authState = MutableStateFlow(AuthUiState())
    val authState: StateFlow<AuthUiState> = _authState

    fun login(email: String, password: String) {
        _authState.value = AuthUiState(isLoading = true)
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthUiState(userId = auth.currentUser?.uid)
                    } else {
                        _authState.value = AuthUiState(error = task.exception?.message ?: "Login failed")
                    }
                }
        }
    }

    fun register(email: String, password: String) {
        _authState.value = AuthUiState(isLoading = true)
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthUiState(userId = auth.currentUser?.uid)
                    } else {
                        _authState.value = AuthUiState(error = task.exception?.message ?: "Register failed")
                    }
                }
        }
    }

    fun resetPassword(email: String) {
        _authState.value = AuthUiState(isLoading = true)
        viewModelScope.launch {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthUiState() // success, no userId change
                    } else {
                        _authState.value = AuthUiState(error = task.exception?.message ?: "Reset password failed")
                    }
                }
        }
    }

    fun clearError() {
        _authState.value = AuthUiState()
    }
}
