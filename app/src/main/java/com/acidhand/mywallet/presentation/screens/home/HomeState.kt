package com.acidhand.mywallet.presentation.screens.home

import com.acidhand.mywallet.R
import com.acidhand.mywallet.presentation.models.Friend
import com.acidhand.mywallet.presentation.models.MenuOptions
import com.acidhand.mywallet.presentation.models.Services

data class HomeState(
    val name: String,
    val address: String,
    val photo: String,
    val balance: Double,
    val friendsList: List<Friend>,
    val servicesList: List<Services>,
    val menuOptionsList: List<MenuOptions>,
    val isLoading: Boolean,
    val isError: Boolean
) {
    companion object {
        val INITIAL = HomeState(
            name = "",
            address = "",
            photo = R.drawable.default_photo.toString(),
            balance = 0.00,
            friendsList = emptyList(),
            servicesList = Services.values().toList(),
            menuOptionsList = MenuOptions.values().toList(),
            isLoading = false,
            isError = false
        )
    }
}