package com.androidmodule.wallpaper.di

import com.androidmodule.wallpaper.BuildConfig
import com.androidmodule.wallpaper.data.Repository
import com.androidmodule.wallpaper.data.remote.ApiService
import com.androidmodule.wallpaper.utils.GuideUtils
import com.androidmodule.wallpaper.viewmodel.GuideViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val guideModule = module(override = true) {
    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.NONE)

        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(GuideUtils.baseUrl ?: BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }

    single { Repository(get()) }
    viewModel { GuideViewModel(get()) }
}
