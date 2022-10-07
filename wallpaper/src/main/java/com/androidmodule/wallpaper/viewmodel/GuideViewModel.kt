package com.androidmodule.wallpaper.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.androidmodule.wallpaper.data.Repository

class GuideViewModel(private val repository: Repository) : ViewModel() {
    fun getData(packageName: String) = repository.getData(packageName).asLiveData()
}