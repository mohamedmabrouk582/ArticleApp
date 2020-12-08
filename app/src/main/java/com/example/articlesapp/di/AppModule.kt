package com.example.articlesapp.di

import android.app.Application
import android.content.Context
import com.example.articlesapp.data.api.ArticleRepository
import com.example.articlesapp.data.model.ArticleResponse
import com.example.articlesapp.viewModels.base.BaseViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Provides
    @Singleton
     fun getViewModelFactory(application: Application,@ApplicationContext context: Context , articleRepository: ArticleRepository): BaseViewModelFactory =
        BaseViewModelFactory(application,context,articleRepository)

}