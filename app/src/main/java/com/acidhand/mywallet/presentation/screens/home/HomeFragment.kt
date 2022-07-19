package com.acidhand.mywallet.presentation.screens.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.acidhand.mywallet.presentation.compose.theme.MyWalletTheme
import com.acidhand.mywallet.presentation.screens.home.composable.ErrorScreen
import com.acidhand.mywallet.presentation.screens.home.composable.HomeContent
import com.acidhand.mywallet.presentation.screens.home.composable.HomeMenu
import com.acidhand.mywallet.presentation.screens.home.composable.TopBar
import com.acidhand.mywallet.utils.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            viewModel.getNavController(findNavController())
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            MyWalletTheme() {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { TopBar(onOptionMenuClick = { scope.launch { scaffoldState.drawerState.open() } }) },
                    drawerContent = {
                        HomeMenu(
                            name = state.name,
                            address = state.address,
                            photo = state.photo,
                            optionsList = state.menuOptionsList,
                            onDismissClick = { scope.launch { scaffoldState.drawerState.close() } },
                            onOptionItemClick = {
                                viewModel.intents(
                                    intent = HomeIntent.OnMenuItemClick(
                                        menuOptions = it
                                    )
                                )
                            },
                            onLogoutClick = { viewModel.intents(intent = HomeIntent.OnLogoutClick) }
                        )
                    }
                ) {
                    HomeScreen(uiState = state, intent = viewModel::intents)
                }
            }
        }
    }
}

@Composable
private fun HomeScreen(
    uiState: HomeState,
    intent: (HomeIntent) -> Unit
) {
    when {
        uiState.isLoading -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        uiState.isError -> ErrorScreen(onClick = { intent(HomeIntent.OnTryAgainClick) })
        else -> HomeContent(uiState = uiState, uiIntent = intent)
    }
}
