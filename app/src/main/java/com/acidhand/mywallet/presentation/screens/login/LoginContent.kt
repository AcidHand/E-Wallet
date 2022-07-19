package com.acidhand.mywallet.presentation.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.East
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.acidhand.mywallet.R
import com.acidhand.mywallet.presentation.compose.theme.BlackTint
import com.acidhand.mywallet.presentation.compose.theme.Dove

@Composable
fun LoginContent(uiState: LoginState, intent: (LoginIntent) -> Unit) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.login_side_image),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.FillHeight
        )
        Column(modifier = Modifier.padding(horizontal = 25.dp, vertical = 30.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = uiState.time,
                    style = MaterialTheme.typography.h5,
                    color = BlackTint
                )
                Icon(
                    imageVector = Icons.Filled.Cloud,
                    contentDescription = null,
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
                Text(
                    text = uiState.weather,
                    style = MaterialTheme.typography.subtitle2,
                    color = BlackTint,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = uiState.date,
                style = MaterialTheme.typography.body2,
                color = Dove,
                modifier = Modifier.padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.login_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 60.dp, height = 40.dp)
            )
            Text(
                text = stringResource(id = R.string.app_title),
                style = MaterialTheme.typography.h5,
                color = BlackTint,
                modifier = Modifier.padding(top = 18.dp)
            )
            Text(
                text = stringResource(id = R.string.login_detailed_info),
                style = MaterialTheme.typography.body2,
                color = Dove,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.login_join),
                style = MaterialTheme.typography.body2,
                color = Dove,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clickable { intent(LoginIntent.OnJoinFreeClick) }
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { intent(LoginIntent.OnSignInClick) },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login_sign_in),
                    style = MaterialTheme.typography.subtitle2,
                    color = BlackTint
                )
                Icon(
                    imageVector = Icons.Filled.East,
                    contentDescription = null,
                    tint = BlackTint,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.login_create_an_account),
                style = MaterialTheme.typography.body2,
                color = BlackTint,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .clickable { intent(LoginIntent.OnCreateAccountClick) }
            )
        }
    }
}
