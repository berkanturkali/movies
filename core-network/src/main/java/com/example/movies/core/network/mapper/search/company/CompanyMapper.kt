package com.example.movies.core.network.mapper.search.company

import com.example.movies.core.model.search.company.Company
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.search.company.CompanyDTO
import javax.inject.Inject

class CompanyMapper @Inject constructor() : RemoteResponseModelMapper<CompanyDTO, Company> {
    override fun mapFromModel(model: CompanyDTO): Company {
        return Company(
            id = model.id,
            logo = model.logoPath?.let { "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${model.logoPath}" },
            name = model.name
        )
    }
}