package com.acidhand.mywallet.presentation.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Workspaces
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.acidhand.mywallet.R
import com.acidhand.mywallet.presentation.compose.theme.BlackTint
import com.acidhand.mywallet.presentation.compose.theme.Dove

@Composable
fun TopBar(onOptionMenuClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(start = 25.dp, end = 25.dp, top = 30.dp)
            .fillMaxWidth()
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.login_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 47.dp, height = 31.dp)
            )
            Text(
                text = stringResource(id = R.string.app_title),
                style = MaterialTheme.typography.h5,
                color = BlackTint,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        IconButton(onClick = { onOptionMenuClick() }) {
            Icon(
                imageVector = Icons.Filled.Workspaces,
                contentDescription = null,
                tint = Dove
            )
        }
    }
}
