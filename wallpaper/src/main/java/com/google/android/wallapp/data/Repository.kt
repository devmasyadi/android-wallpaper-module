package com.google.android.wallapp.data

import com.google.android.wallapp.data.remote.ApiService
import com.google.android.wallapp.domain.WallpaperModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(
    private val apiService: ApiService
) : IRepository {
    override fun getData(packageName: String): Flow<Resource<WallpaperModel>> {
        return flow {
            try {
                emit(Resource.Loading())
                val result = apiService.getData(packageName)
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}