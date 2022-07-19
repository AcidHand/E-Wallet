package com.acidhand.mywallet.presentation.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.acidhand.mywallet.presentation.compose.theme.MyWalletTheme
import com.acidhand.mywallet.utils.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            val state by viewModel.uiState.collectAsStateWithLifecycle()
            viewModel.getNavController(findNavController())

            MyWalletTheme {
                Surface {
                    LoginScreen(uiState = state, intent = viewModel::intents)
                }
            }
        }
    }

}

@Composable
fun LoginScreen(
    uiState: LoginState,
    intent: (LoginIntent) -> Unit
) {
    LoginContent(uiState = uiState, intent = intent)
}
