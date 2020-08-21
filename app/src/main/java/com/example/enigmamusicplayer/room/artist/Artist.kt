package com.example.enigmamusicplayer.room.artist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Artist(@PrimaryKey(autoGenerate = true) var idArtist:Int = 0,
             var album:String,
             var name:String,
             var image:String
)
