package com.example.enigmamusicplayer.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel:ViewModel() {
    var songList = mutableListOf<Song>()
    var songLiveData = MutableLiveData<List<Song>>()

    init
        {
            songList.add(Song("Lathi","Weird Genius","https://adagio.news/wp-content/uploads/2017/09/Weird-Genius-adagio-tv-russia-news-1.jpg"))
            songList.add(Song("Pamit kerjo","NDX AKA","https://asset-a.grid.id/crop/0x0:0x0/750x500/photo/grid/original/33964_ndx.jpg"))
            songList.add(Song("Tetep Neng Ati","Om Wawes","https://cdn2.tstatic.net/jogja/foto/bank/images/om-wawes-janjikan-lagu-koe-lungo-lebih-menggigit.jpg"))
            songLiveData.value = songList
        }


    fun addSong(newSong: Song){
        songList.add(newSong)
        songLiveData.value = songList
    }


    fun getSongs() = songLiveData as LiveData<List<Song>>
}