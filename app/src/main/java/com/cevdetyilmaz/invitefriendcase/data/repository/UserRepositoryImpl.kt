package com.cevdetyilmaz.invitefriendcase.data.repository

import com.cevdetyilmaz.invitefriendcase.common.Resource
import com.cevdetyilmaz.invitefriendcase.data.mapper.InviteScreenMapper
import com.cevdetyilmaz.invitefriendcase.data.source.RemoteDataSource
import com.cevdetyilmaz.invitefriendcase.di.IoDispatcher
import com.cevdetyilmaz.invitefriendcase.domain.model.InviteScreen
import com.cevdetyilmaz.invitefriendcase.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */

/**
 * repository layer responsible for data providing without where is come from remote or locale.
 */

class UserRepositoryImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val mapper: InviteScreenMapper,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : UserRepository {
    override suspend fun getInviteList(): Resource<InviteScreen> {
        return try {
            withContext(dispatcher) {
                when (val response = dataSource.getInviteList()) {
                    is Resource.Success -> Resource.Success(mapper.mapToDomainModel(response.data))
                    is Resource.Failure -> Resource.Failure(response.error)
                    Resource.Loading -> Resource.Loading
                }
            }
        } catch (e: Exception) {
            Resource.Failure(e.toString())
        }
    }
}