package com.acidhand.mywallet.presentation.screens.home

import com.acidhand.mywallet.presentation.models.Friend
import com.acidhand.mywallet.presentation.models.MenuOptions
import com.acidhand.mywallet.presentation.models.Services

sealed class HomeIntent {
    object OnBalanceAddButtonClick : HomeIntent()
    object OnSendMoneyIconClick : HomeIntent()
    object OnSendMoneyAddButtonClick : HomeIntent()
    data class OnFriendItemClick(val friend: Friend) : HomeIntent()
    object OnServiceIconClick : HomeIntent()
    data class OnServiceItemClick(val service: Services) : HomeIntent()
    data class OnMenuItemClick(val menuOptions: MenuOptions) : HomeIntent()
    object OnLogoutClick : HomeIntent()
    object OnTryAgainClick : HomeIntent()
}

