package com.example.enigmamusicplayer.room.song

import androidx.lifecycle.LiveData

class SongRepository(
    private val songDao: SongDao) {

    fun songWithArtistId(id: Int) = songDao.getSongWithArtistId(id)

    val allSong: LiveData<List<Song>> = songDao.getAllSong()

    fun getSongById(id:Int) = songDao.getSongById(id)

    fun createSong(song:Song) = songDao.createSong(song)

}