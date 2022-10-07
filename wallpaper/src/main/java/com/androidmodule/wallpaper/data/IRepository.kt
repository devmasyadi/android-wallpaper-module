package com.androidmodule.wallpaper.data

import com.androidmodule.wallpaper.domain.WallpaperModel
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getData(packageName: String): Flow<Resource<WallpaperModel>>
}