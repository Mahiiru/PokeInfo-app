package com.mahiiru.pokeinfo.di

import com.mahiiru.pokeinfo.common.Constants
import com.mahiiru.pokeinfo.data.remote.PokeApi
import com.mahiiru.pokeinfo.data.repository.PokemonRepositoryImpl
import com.mahiiru.pokeinfo.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokeApi() : PokeApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokeApi) : PokemonRepository{
        return PokemonRepositoryImpl(api)
    }
}