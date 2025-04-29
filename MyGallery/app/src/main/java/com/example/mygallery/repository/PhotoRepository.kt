package com.example.mygallery.repository

import com.example.mygallery.model.Photo
import java.util.UUID

class PhotoRepository {
    // Fungsi untuk mendapatkan daftar foto dummy
    fun getPhotos(): List<Photo> {
        return (1..20).map { index ->
            Photo(
                id = UUID.randomUUID().toString(),
                imageUrl = "https://picsum.photos/id/${index + 100}/300/300",
                title = "Foto #$index",
                description = "Deskripsi foto #$index yang menampilkan gambar menarik",
                uploadDate = "2024-04-${index % 30 + 1}"
            )
        }
    }
}