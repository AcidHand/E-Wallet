package com.acidhand.mywallet.presentation.screens.login

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.acidhand.mywallet.R
import com.acidhand.mywallet.utils.DateConverter
import com.acidhand.mywallet.utils.provideDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.random.Random

@SuppressLint("NewApi")
@HiltViewModel
class LoginViewModel @Inject constructor(converter: DateConverter) : ViewModel() {

    private val _state = MutableStateFlow(LoginState.INITIAL)
    private var state: LoginState by _state
    val uiState = _state.asStateFlow()
    var navController: NavController? = null

    init {
        state = state.copy(
            date = converter.provideDate(),
            time = converter.provideTime(),
            weather = "${Random.nextInt(from = -30, until = 30)} °C"
        )
    }

    fun intents(intent: LoginIntent) {
        when (intent) {
            LoginIntent.OnCreateAccountClick -> navController?.navigate(R.id.to_home_fragment)
            LoginIntent.OnJoinFreeClick -> navController?.navigate(R.id.to_home_fragment)
            LoginIntent.OnSignInClick -> navController?.navigate(R.id.to_home_fragment)
        }
    }

    fun getNavController(navController: NavController) {
        this.navController = navController
    }
}
