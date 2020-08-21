package com.example.enigmamusicplayer.view_model.artist

import android.app.Application
import androidx.lifecycle.*
import com.example.enigmamusicplayer.room.AppRoomDatabase
import com.example.enigmamusicplayer.room.artist.Artist
import com.example.enigmamusicplayer.room.artist.ArtistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistViewModel(application: Application): AndroidViewModel(application) {

    private val repository =
        ArtistRepository(AppRoomDatabase.getDatabaseInstance(application).artistDao())

    fun allArtist() = repository.allArtist

    fun getArtistById(id:Int) =  repository.getArtistById(id)

    //menggunakan coroutine
    //karena baik ke db maupun network itu membutuhkan waktu yang lebih ekstra
    fun createNewArtist(artist: Artist){
        viewModelScope.launch(Dispatchers.IO) {
            repository.createArtist(artist)
        }
    }

}