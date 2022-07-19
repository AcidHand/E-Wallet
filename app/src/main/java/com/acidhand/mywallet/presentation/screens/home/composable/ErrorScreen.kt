package com.acidhand.mywallet.presentation.screens.home.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.acidhand.mywallet.R
import com.acidhand.mywallet.presentation.compose.theme.BlackTint

@Composable
fun ErrorScreen(onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(bottom = 30.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.Warning,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(
            text = stringResource(id = R.string.error_text1),
            style = MaterialTheme.typography.subtitle2,
            color = BlackTint
        )
        Box(modifier = Modifier.width(300.dp)) {
            Text(
                text = stringResource(id = R.string.error_text2),
                style = MaterialTheme.typography.subtitle2,
                color = BlackTint,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onClick() },
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = stringResource(id = R.string.error_button),
                color = BlackTint
            )
        }
    }
}