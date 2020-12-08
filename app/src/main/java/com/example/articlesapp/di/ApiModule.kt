package com.example.articlesapp.di

import com.example.articlesapp.BuildConfig
import com.example.articlesapp.data.api.ArticlesApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {

    @Singleton
    @Provides
    fun getApi(retrofit: Retrofit) : ArticlesApi =
        retrofit.create(ArticlesApi::class.java)

    @Singleton
    @Provides
    fun getRetrofit(client: OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()

    @Singleton
    @Provides
    fun getOkClient(interceptor: HttpLoggingInterceptor) : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor).build()

    @Singleton
    @Provides
    fun getInterceptor() : HttpLoggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level=HttpLoggingInterceptor.Level.BODY
        }
}