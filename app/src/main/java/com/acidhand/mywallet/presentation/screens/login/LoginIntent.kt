package com.acidhand.mywallet.presentation.screens.login

sealed class LoginIntent {
    object OnJoinFreeClick : LoginIntent()
    object OnSignInClick : LoginIntent()
    object OnCreateAccountClick : LoginIntent()
}
