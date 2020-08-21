package com.example.enigmamusicplayer.room.artist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArtistDao {

    @Insert
    fun createArtist(artist: Artist)

    @Query(value = "SELECT * FROM Artist")
    fun getAllArtist(): LiveData<List<Artist>>

    @Query(value = "SELECT * FROM Artist WHERE idArtist = :id")
    fun getArtistById(id:Int): LiveData<List<Artist>>

}