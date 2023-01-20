package com.example.apitest.di

import com.example.apitest.BuildConfig
import com.example.apitest.data.api.ApiHelper
import com.example.apitest.data.api.ApiHelperlmpl
import com.example.apitest.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideURl() = BuildConfig.URL

    @Singleton
    @Provides
    fun provideOkHtppClient(): OkHttpClient {
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().addInterceptor(interceptor).build()
        } else {
            return OkHttpClient.Builder().build()
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, URL: String): Retrofit {
        return Retrofit.Builder().baseUrl(URL).addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperlmpl): ApiHelper = apiHelper
}