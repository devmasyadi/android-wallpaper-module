package com.google.android.wallapp.di

import com.google.android.wallapp.data.Repository
import com.google.android.wallapp.data.remote.ApiService
import com.google.android.wallapp.utils.WallpaperUtils
import com.google.android.wallapp.viewmodel.WallpaperViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val wallpaperModule = module(override = true) {
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
        val retrofit = WallpaperUtils.style?.let { url ->
            Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(get())
                .build()
        }
        retrofit?.create(ApiService::class.java)
    }

    single { Repository(get()) }
    viewModel { WallpaperViewModel(get()) }
}
