package com.workdev.example.di

import dagger.Module
import com.workdev.domain.repo.getAllCatsRepo
import com.workdev.domain.usecase.getAllCatsUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun ProvideUseCase(categoriesRepo: getAllCatsRepo) :getAllCatsUseCase{

        return getAllCatsUseCase(categoriesRepo)

    }


}