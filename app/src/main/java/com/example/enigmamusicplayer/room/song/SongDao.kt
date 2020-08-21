package com.example.enigmamusicplayer.room.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.enigmamusicplayer.room.artist.Artist

@Dao
interface SongDao {

    @Transaction
    @Query("SELECT * FROM Artist")
    fun getSongWithArtist(): LiveData<List<SongWithArtist>>

    @Insert
    fun createSong(song: Song)

    @Query(value = "SELECT * FROM Song")
    fun getAllSong(): LiveData<List<Song>>

    @Query(value = "SELECT * FROM Song WHERE idSong = :id")
    fun getSongById(id:Int): Song

    @Query(value = "SELECT * FROM Song WHERE songArtistId = :id")
    fun getSongWithArtistId(id:Int): LiveData<List<Song>>
}


