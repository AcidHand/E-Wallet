package com.acidhand.mywallet.data.useCase

import com.acidhand.mywallet.domain.models.request.MockFriendInfoApi
import com.acidhand.mywallet.domain.models.request.MockUserInfoApi
import com.acidhand.mywallet.domain.useCase.FetchUserInfoUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockFetchUserInfoUseCase : FetchUserInfoUseCase {
    override fun invoke(): Flow<MockUserInfoApi> {
        return flow {
            delay(2000)
            emit(
                value = MockUserInfoApi(
                    name = "Tomas",
                    surname = "Anderson",
                    address = "Seattle, Washington",
                    photo = null,
                    balance = 20600.00,
                    friendsList = listOf(
                        MockFriendInfoApi("Mike", photo = null),
                        MockFriendInfoApi("Kate", photo = null),
                        MockFriendInfoApi("Bill", photo = null),
                        MockFriendInfoApi("Tom", photo = null),
                        MockFriendInfoApi("Jade", photo = null),
                        MockFriendInfoApi("Ben", photo = null),
                        MockFriendInfoApi("Jennifer", photo = null)
                    )
                )
            )
        }
    }
}
