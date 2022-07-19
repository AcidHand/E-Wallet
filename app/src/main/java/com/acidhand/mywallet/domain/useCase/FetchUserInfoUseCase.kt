package com.acidhand.mywallet.domain.useCase

import com.acidhand.mywallet.domain.models.request.MockUserInfoApi
import kotlinx.coroutines.flow.Flow

interface FetchUserInfoUseCase {
    operator fun invoke(): Flow<MockUserInfoApi>
}
