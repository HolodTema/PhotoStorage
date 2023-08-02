package com.terabyte.photostorage.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface PhotoService {

    @GET()
    fun getMiniPhotos(): Call<Unit>

    @GET()
    fun getFullPhoto(): Call<Unit>

    @POST()
    fun uploadPhoto(): Call<Unit>
}