package com.acidhand.mywallet.di

import com.acidhand.mywallet.data.useCase.MockFetchUserInfoUseCase
import com.acidhand.mywallet.domain.useCase.FetchUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideFetchUserUseCase(): FetchUserInfoUseCase {
        return MockFetchUserInfoUseCase()
    }
}
