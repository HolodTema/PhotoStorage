package com.terabyte.photostorage.retrofit

import com.terabyte.photostorage.SERVER_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.reflect.KProperty

object RetrofitManager {
    private val retrofit by RetrofitDelegate()
    private val photoService by PhotoServiceDelegate()


    fun getMiniPhotos() {
        val call = photoService.getMiniPhotos().enqueue(object: Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    class RetrofitDelegate {
        operator fun getValue(retrofitManager: RetrofitManager, property: KProperty<*>): Retrofit {
            return Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .build()
        }
    }

    class PhotoServiceDelegate {
        operator fun getValue(retrofitManager: RetrofitManager, property: KProperty<*>): PhotoService {
            return retrofit.create(PhotoService::class.java)
        }
    }
}