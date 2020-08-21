package com.example.enigmamusicplayer.view_model.song

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.enigmamusicplayer.room.AppRoomDatabase
import com.example.enigmamusicplayer.room.song.Song
import com.example.enigmamusicplayer.room.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel(application: Application):AndroidViewModel(application) {

    private val repository: SongRepository
    val allSong: LiveData<List<Song>>

    init{
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        repository = SongRepository(songDao)
        allSong = repository.allSong
    }

    //menggunakan coroutine
    //karena baik ke db maupun network itu membutuhkan waktu yang lebih ekstra
    fun createNewSong(song: Song){
        viewModelScope.launch(Dispatchers.IO) {
            repository.createSong(song)
        }
    }

    fun getSongById(id:Int){
        repository.getSongById(id)
    }

    fun getSongWithArtistId(id:Int) = repository.songWithArtistId(id)
}