package com.acidhand.mywallet.presentation.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.acidhand.mywallet.R
import com.acidhand.mywallet.presentation.compose.theme.BlackTint
import com.acidhand.mywallet.presentation.compose.theme.LightGrey
import com.acidhand.mywallet.presentation.models.MenuOptions

@Composable
fun HomeMenu(
    name: String,
    address: String,
    photo: String,
    optionsList: List<MenuOptions>,
    onDismissClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onOptionItemClick: (MenuOptions) -> Unit
) {
    Column(modifier = Modifier.background(color = LightGrey)) {
        DrawerHeader(
            name = name,
            address = address,
            photo = photo,
            onClick = { onDismissClick() })
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            DrawerBody(optionsList = optionsList, onClick = { onOptionItemClick(it) })
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier.clickable { onLogoutClick() }) {
                Icon(
                    imageVector = Icons.Filled.Logout,
                    contentDescription = null,
                    tint = BlackTint
                )
                Text(
                    text = stringResource(id = R.string.menu_logout),
                    style = MaterialTheme.typography.subtitle2,
                    color = BlackTint
                )
            }
            Text(
                text = stringResource(id = R.string.menu_version),
                style = MaterialTheme.typography.overline,
                color = BlackTint,
                modifier = Modifier.padding(top = 60.dp, bottom = 25.dp)
            )
        }
    }
}

@Composable
private fun DrawerHeader(
    name: String,
    address: String,
    photo: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .width(210.dp)
                .background(color = Color.White, shape = RoundedCornerShape(bottomEndPercent = 50))
        ) {
            Row(modifier = Modifier.padding(start = 30.dp, top = 30.dp, bottom = 30.dp)) {
                Image(
                    painter = painterResource(id = photo.toInt()),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(45.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .height(45.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.subtitle2,
                        color = BlackTint
                    )
                    Text(
                        text = address,
                        style = MaterialTheme.typography.overline,
                        color = BlackTint
                    )
                }
            }
        }
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = null,
            tint = BlackTint,
            modifier = Modifier
                .padding(end = 30.dp)
                .clickable { onClick() }
        )
    }
}

@Composable
private fun DrawerBody(optionsList: List<MenuOptions>, onClick: (MenuOptions) -> Unit) {
    LazyColumn() {
        items(optionsList) {
            DrawerOptionItem(option = it, onClick = { onClick(it) })
        }
    }
}

@Composable
private fun DrawerOptionItem(option: MenuOptions, onClick: () -> Unit) {
    Box(modifier = Modifier.height(50.dp)) {
        Text(
            text = stringResource(id = option.id),
            style = MaterialTheme.typography.body2,
            color = BlackTint,
            modifier = Modifier.clickable { onClick() }
        )
    }
}
