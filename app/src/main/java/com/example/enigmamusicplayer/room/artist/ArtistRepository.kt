package com.example.enigmamusicplayer.room.artist

import androidx.lifecycle.LiveData

class ArtistRepository(private val artistDao: ArtistDao) {

    val allArtist: LiveData<List<Artist>> = artistDao.getAllArtist()

    fun createArtist(artist:Artist) = artistDao.createArtist(artist)

    fun getArtistById(id:Int) = artistDao.getArtistById(id)
}