package com.google.android.wallapp.data.remote

import com.google.android.wallapp.domain.WallpaperModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("apps")
    suspend fun getData(
        @Query("packageName") packageName: String?
    ): WallpaperModel
}