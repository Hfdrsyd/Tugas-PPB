package com.example.mygallery.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mygallery.model.Photo
import com.example.mygallery.repository.PhotoRepository
import java.util.UUID

class PhotoViewModel : ViewModel() {
    private val repository = PhotoRepository()

    var photos by mutableStateOf<List<Photo>>(emptyList())
        private set

    init {
        loadPhotos()
    }
    private fun loadPhotos() {
        photos = repository.getPhotos()
    }
    fun uploadPhoto(imageUrl: String, title: String, description: String): Boolean {
        // Simulasi upload foto
        val newPhoto = Photo(
            id = UUID.randomUUID().toString(),
            imageUrl = imageUrl,
            title = title,
            description = description,
            uploadDate = "2024-04-29" // Tanggal hari ini
        )

        photos = photos + newPhoto
        return true
    }

    fun getPhotoById(id: String): Photo? {
        return photos.find { it.id == id }
    }
}