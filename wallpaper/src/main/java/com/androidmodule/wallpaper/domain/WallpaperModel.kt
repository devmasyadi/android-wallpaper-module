package com.androidmodule.wallpaper.domain

import com.google.gson.annotations.SerializedName

data class WallpaperModel(

	@field:SerializedName("sizeNativeHome")
	val sizeNativeHome: String? = null,

	@field:SerializedName("wallpapersWithCategory")
	val wallpapersWithCategory: List<WallpapersWithCategoryItem>? = null,

	@field:SerializedName("intervalNativeHome")
	val intervalNativeHome: Int? = null,

	@field:SerializedName("isShowBannerHome")
	val isShowBannerHome: Boolean? = null,

	@field:SerializedName("positionBannerHome")
	val positionBannerHome: String? = null,

	@field:SerializedName("wallpapers")
	val wallpapers: List<WallpapersItem>? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("packageName")
	val packageName: String? = null,

	@field:SerializedName("isShowNativeHome")
	val isShowNativeHome: Boolean? = null,

	@field:SerializedName("positionBannerDetail")
	val positionBannerDetail: String? = null,

	@field:SerializedName("isShowBannerDetail")
	val isShowBannerDetail: Boolean? = null,

	@field:SerializedName("isWithCategory")
	val isWithCategory: Boolean? = null
)

data class WallpapersItem(

	@field:SerializedName("extension")
	val extension: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class WallpapersWithCategoryItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("wallpapers")
	val wallpapers: List<WallpapersItem>? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("categoryName")
	val categoryName: String? = null
)
