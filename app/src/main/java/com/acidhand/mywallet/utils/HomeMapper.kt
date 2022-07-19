package com.acidhand.mywallet.utils

import com.acidhand.mywallet.R
import com.acidhand.mywallet.domain.models.request.MockFriendInfoApi
import com.acidhand.mywallet.presentation.models.Friend
import javax.inject.Inject

class HomeMapper @Inject constructor() {
    fun providePhoto(photo: String?): String {
        return if (photo.isNullOrEmpty()) R.drawable.default_photo.toString() else photo
    }

    fun mapToPersonList(friendsList: List<MockFriendInfoApi>): List<Friend> {
        return friendsList.map {
            Friend(
                name = it.name,
                photo = if (it.photo.isNullOrEmpty()) R.drawable.default_photo.toString() else it.photo
            )
        }
    }
}
