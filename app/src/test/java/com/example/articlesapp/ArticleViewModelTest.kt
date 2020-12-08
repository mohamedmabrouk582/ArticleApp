package com.example.articlesapp

import com.example.articlesapp.data.api.ArticlesApi
import com.example.articlesapp.data.model.ArticleResponse
import com.example.articlesapp.utils.network.RequestListener
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class ArticleViewModelTest {
    private val testDispatcher= TestCoroutineDispatcher()
    private val testScope= TestCoroutineScope()

    @Mock
    lateinit var listener: RequestListener<ArticleResponse>

    @Mock
    lateinit var repository: ArticlesApi

    @Mock
    lateinit var mockResponse:ArticleResponse

    @Before
    fun before(){
        Dispatchers.setMain(testDispatcher)
        listener= Mockito.mock(RequestListener::class.java) as RequestListener<ArticleResponse>
        repository= Mockito.mock(ArticlesApi::class.java)
        mockResponse = Mockito.mock(ArticleResponse::class.java)

    }


    @After
    fun after(){
        Dispatchers.resetMain()
        testScope.cleanupTestCoroutines()
    }

    @Test
    fun testListArticles() = testScope.runBlockingTest {
        val resf: Deferred<ArticleResponse> = Mockito.mock(Deferred::class.java) as Deferred<ArticleResponse>
        whenever(repository.getArticles()).thenReturn(resf)
        verify(resf,)

    }
}