package com.example.enigmamusicplayer.room.song

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.enigmamusicplayer.room.artist.Artist

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) val idSong: Int = 0,
    val songArtistId: Int,
    val songName: String,
    val songDuration: String
)

data class SongWithArtist(
    @Embedded val artist:Artist,
    @Relation(
        parentColumn = "idArtist",
        entityColumn = "songArtistId"
    )
    val song:Song

)
