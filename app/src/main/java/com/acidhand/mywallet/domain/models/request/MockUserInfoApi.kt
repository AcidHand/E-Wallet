package com.acidhand.mywallet.domain.models.request

data class MockUserInfoApi(
    val name: String,
    val surname: String,
    val address: String,
    val photo: String? = null,
    val balance: Double,
    val friendsList: List<MockFriendInfoApi>
)
