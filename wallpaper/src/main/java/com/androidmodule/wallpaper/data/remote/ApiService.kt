package com.androidmodule.wallpaper.data.remote

import com.androidmodule.wallpaper.domain.WallpaperModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("wallpaper/apps")
    suspend fun getData(
        @Query("packageName") packageName: String?
    ): WallpaperModel
}