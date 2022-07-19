package com.acidhand.mywallet.presentation.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Movie
import androidx.compose.material.icons.outlined.Workspaces
import androidx.compose.ui.graphics.vector.ImageVector
import com.acidhand.mywallet.R

enum class Services(val id: Int, val image: ImageVector) {
    SEND_MONEY(id = R.string.home_send_money, image = Icons.Filled.AddShoppingCart),
    RECEIVE_MONEY(id = R.string.home_receive_money, image = Icons.Filled.ShoppingCartCheckout),
    MOBILE_PREPAID(id = R.string.home_mobile_prepaid, image = Icons.Filled.PhoneAndroid),
    ELECTRICITY_BILL(id = R.string.home_electricity_bill, image = Icons.Filled.Bolt),
    CASHBACK_OFFER(id = R.string.home_cashback_offer, image = Icons.Filled.Sell),
    MOVIE_TICKETS(id = R.string.home_movie_tickets, image = Icons.Outlined.Movie),
    FLIGHT_TICKETS(id = R.string.home_flight_tickets, image = Icons.Filled.Flight),
    MORE_OPTIONS(id = R.string.home_more_options, image = Icons.Outlined.Workspaces)
}
