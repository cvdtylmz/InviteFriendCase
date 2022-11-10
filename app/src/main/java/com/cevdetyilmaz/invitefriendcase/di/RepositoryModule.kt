package com.cevdetyilmaz.invitefriendcase.di

import com.cevdetyilmaz.invitefriendcase.data.repository.UserRepositoryImpl
import com.cevdetyilmaz.invitefriendcase.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(
        repository: UserRepositoryImpl
    ): UserRepository

}