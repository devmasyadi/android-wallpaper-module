package com.google.android.wallapp.data

import com.google.android.wallapp.domain.WallpaperModel
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getData(packageName: String): Flow<Resource<WallpaperModel>>
}