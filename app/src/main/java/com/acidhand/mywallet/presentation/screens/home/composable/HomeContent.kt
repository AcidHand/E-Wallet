package com.acidhand.mywallet.presentation.screens.home.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.acidhand.mywallet.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.acidhand.mywallet.presentation.compose.theme.BlackTint
import com.acidhand.mywallet.presentation.compose.theme.Dove
import com.acidhand.mywallet.presentation.compose.theme.LightGrey
import com.acidhand.mywallet.presentation.models.Friend
import com.acidhand.mywallet.presentation.models.Services
import com.acidhand.mywallet.presentation.screens.home.HomeIntent
import com.acidhand.mywallet.presentation.screens.home.HomeState
import com.acidhand.mywallet.utils.gridItems

@Composable
fun HomeContent(uiState: HomeState, uiIntent: (HomeIntent) -> Unit) {
    LazyColumn {
        item {
            Column(modifier = Modifier.padding(start = 25.dp, end = 25.dp, top = 50.dp)) {
                Text(
                    text = stringResource(id = R.string.home_account_overview),
                    style = MaterialTheme.typography.subtitle2,
                    color = Dove
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(shape = RoundedCornerShape(15), color = LightGrey)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(start = 25.dp, top = 25.dp)) {
                        Text(
                            text = uiState.balance.toString(),
                            style = MaterialTheme.typography.h5,
                            color = BlackTint
                        )
                        Text(
                            text = stringResource(id = R.string.home_current_balance),
                            style = MaterialTheme.typography.overline,
                            color = Dove,
                            modifier = Modifier.padding(top = 8.dp, bottom = 25.dp)
                        )
                    }
                    IconButton(
                        onClick = { uiIntent(HomeIntent.OnBalanceAddButtonClick) },
                        modifier = Modifier
                            .padding(end = 25.dp)
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colors.primary)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = BlackTint
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.home_send_money),
                        style = MaterialTheme.typography.subtitle2,
                        color = Dove
                    )
                    Icon(
                        imageVector = Icons.Filled.DocumentScanner,
                        contentDescription = null,
                        tint = Dove,
                        modifier = Modifier.clickable { uiIntent(HomeIntent.OnSendMoneyIconClick) }
                    )
                }
            }
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 25.dp, top = 20.dp)
            ) {
                item {
                    IconButton(
                        onClick = { uiIntent(HomeIntent.OnSendMoneyAddButtonClick) },
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .clip(shape = CircleShape)
                            .background(color = MaterialTheme.colors.primary)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            tint = BlackTint,
                            contentDescription = null
                        )
                    }
                }
                items(uiState.friendsList) {
                    FriendItem(
                        friend = it,
                        onClick = { uiIntent(HomeIntent.OnFriendItemClick(friend = it)) })
                }
            }
            Column(
                modifier = Modifier.padding(
                    start = 25.dp,
                    end = 25.dp,
                    top = 20.dp,
                    bottom = 30.dp
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.home_services),
                        style = MaterialTheme.typography.subtitle2,
                        color = Dove
                    )
                    Icon(
                        imageVector = Icons.Filled.Tune,
                        contentDescription = null,
                        tint = Dove,
                        modifier = Modifier.clickable { uiIntent(HomeIntent.OnServiceIconClick) }
                    )
                }
            }
        }
        gridItems(
            modifier = Modifier.padding(start = 25.dp),
            data = uiState.servicesList,
            columns = 4
        ) {
            ServiceItem(
                service = it,
                onClick = { uiIntent(HomeIntent.OnServiceItemClick(service = it)) })
        }
    }
}

@Composable
private fun FriendItem(friend: Friend, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 10.dp)
            .background(shape = RoundedCornerShape(15), color = LightGrey)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = friend.photo.toInt()),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 22.dp, start = 30.dp, end = 30.dp)
                .clip(shape = CircleShape)
                .size(40.dp)
        )
        Text(
            text = friend.name,
            style = MaterialTheme.typography.overline,
            color = Dove,
            modifier = Modifier
                .padding(top = 15.dp, bottom = 20.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun ServiceItem(service: Services, onClick: () -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(shape = RoundedCornerShape(15), color = LightGrey)
                .clickable { onClick() }
        ) {
            Icon(
                imageVector = service.image,
                contentDescription = null,
                tint = Dove,
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
        Text(
            text = stringResource(id = service.id),
            style = MaterialTheme.typography.overline,
            color = Dove,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 6.dp, bottom = 20.dp)
                .width(60.dp)
        )
    }
}
