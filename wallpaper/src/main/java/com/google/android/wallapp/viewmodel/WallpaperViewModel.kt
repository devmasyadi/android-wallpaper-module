package com.google.android.wallapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.google.android.wallapp.data.Repository

class WallpaperViewModel(private val repository: Repository) : ViewModel() {
    fun getData(packageName: String) = repository.getData(packageName).asLiveData()
}