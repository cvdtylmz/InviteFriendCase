package com.cevdetyilmaz.invitefriendcase.di

import com.cevdetyilmaz.invitefriendcase.data.source.RemoteDataSource
import com.cevdetyilmaz.invitefriendcase.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteDataSource(
        source: RemoteDataSourceImpl
    ): RemoteDataSource

}