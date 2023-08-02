package com.terabyte.photostorage.activity_result_api

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract
import com.terabyte.photostorage.R

class GetPhotoResultContract: ActivityResultContract<Unit, Uri?>() {

    override fun createIntent(context: Context, input: Unit): Intent {
        val intentGallery = Intent(Intent.ACTION_GET_CONTENT)
        intentGallery.type = "image/*"

        val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intentCamera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

        val intentChooser = Intent.createChooser(intentCamera, context.getString(R.string.choose_photo_from))
        intentChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(intentGallery))

        return intentChooser
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        return null
    }
}