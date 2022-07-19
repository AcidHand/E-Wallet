package com.acidhand.mywallet.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.acidhand.mywallet.domain.useCase.FetchUserInfoUseCase
import com.acidhand.mywallet.presentation.models.MenuOptions
import com.acidhand.mywallet.presentation.models.Services
import com.acidhand.mywallet.utils.HomeMapper
import com.acidhand.mywallet.utils.provideDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: FetchUserInfoUseCase,
    private val mapper: HomeMapper
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState.INITIAL)
    private var state: HomeState by _state
    val uiState = _state.asStateFlow()
    var navController: NavController? = null

    init {
        loadUserInfo()
    }

    fun intents(intent: HomeIntent) {
        when (intent) {
            HomeIntent.OnBalanceAddButtonClick -> Unit
            is HomeIntent.OnFriendItemClick -> Unit
            HomeIntent.OnSendMoneyAddButtonClick -> Unit
            HomeIntent.OnSendMoneyIconClick -> Unit
            HomeIntent.OnServiceIconClick -> Unit
            is HomeIntent.OnServiceItemClick -> onServiceItemClicked(service = intent.service)
            HomeIntent.OnLogoutClick -> navController?.navigateUp()
            is HomeIntent.OnMenuItemClick -> onMenuItemClicked(menuOptions = intent.menuOptions)
            HomeIntent.OnTryAgainClick -> loadUserInfo()
        }
    }

    fun getNavController(navController: NavController) {
        this.navController = navController
    }

    private fun loadUserInfo() {
        useCase()
            .onStart { state = state.copy(isLoading = true) }
            .onEach {
                state = state.copy(
                    name = "${it.name} ${it.surname}",
                    address = it.address,
                    photo = mapper.providePhoto(it.photo),
                    balance = it.balance,
                    friendsList = mapper.mapToPersonList(it.friendsList)
                )
            }
            .onCompletion { state = state.copy(isLoading = false) }
            .catch { state = state.copy(isError = true) }
            .launchIn(viewModelScope)
    }

    private fun onServiceItemClicked(service: Services) {
        when (service) {
            Services.SEND_MONEY -> Unit
            Services.RECEIVE_MONEY -> Unit
            Services.MOBILE_PREPAID -> Unit
            Services.ELECTRICITY_BILL -> Unit
            Services.CASHBACK_OFFER -> Unit
            Services.MOVIE_TICKETS -> Unit
            Services.FLIGHT_TICKETS -> Unit
            Services.MORE_OPTIONS -> Unit
        }
    }

    private fun onMenuItemClicked(menuOptions: MenuOptions) {
        when (menuOptions) {
            MenuOptions.HOME -> Unit
            MenuOptions.PROFILE -> Unit
            MenuOptions.ACCOUNTS -> Unit
            MenuOptions.TRANSACTIONS -> Unit
            MenuOptions.STATS -> Unit
            MenuOptions.SETTINGS -> Unit
            MenuOptions.HELP -> Unit
        }
    }
}
