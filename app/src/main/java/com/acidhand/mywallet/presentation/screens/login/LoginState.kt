package com.acidhand.mywallet.presentation.screens.login

data class LoginState(
    val date: String,
    val time: String,
    val weather: String
) {
    companion object {
        val INITIAL = LoginState(
            date = "",
            time = "",
            weather = ""
        )
    }
}
