package com.terabyte.photostorage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.terabyte.photostorage.activity_result_api.GetPhotoResultContract
import com.terabyte.photostorage.databinding.ActivityMainBinding
import com.terabyte.photostorage.ui.MiniPhotoAdapter
import com.terabyte.photostorage.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private val getPhotoLauncher = registerForActivityResult(GetPhotoResultContract()) { uri ->

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        configureRecyclerView()

        binding.buttonUploadToServer.setOnClickListener {
            getPhotoLauncher.launch(Unit)
        }


    }

    private fun configureRecyclerView() {
        binding.recyclerPhotos.layoutManager = GridLayoutManager(this, 2)
        val adapter = MiniPhotoAdapter(this, listOf())
        binding.recyclerPhotos.adapter = adapter
    }
}