package com.workdev.example.di

import com.workdev.data.remote.ApiService
import com.workdev.data.repo.getAllCatsRepoImpL
import com.workdev.domain.repo.getAllCatsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService) :getAllCatsRepo{

        return getAllCatsRepoImpL(apiService)
    }
}