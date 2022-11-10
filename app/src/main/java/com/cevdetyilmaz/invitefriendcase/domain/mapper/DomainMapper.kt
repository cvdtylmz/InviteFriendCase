package com.cevdetyilmaz.invitefriendcase.domain.mapper

/**
 *Created by Cevdet Yilmaz on 09.11.2022
 */
interface DomainMapper<DataType, DomainType> {
    fun mapToDomainModel(dataModel: DataType): DomainType
}