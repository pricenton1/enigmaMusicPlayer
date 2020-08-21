package com.example.enigmamusicplayer.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enigmamusicplayer.room.artist.Artist
import com.example.enigmamusicplayer.room.artist.ArtistDao
import com.example.enigmamusicplayer.room.song.Song
import com.example.enigmamusicplayer.room.song.SongDao

@Database(entities = arrayOf(Artist::class, Song::class), version = 3, exportSchema = false)

abstract class AppRoomDatabase: RoomDatabase(){

    abstract  fun artistDao(): ArtistDao
    abstract  fun songDao():SongDao

    companion object{
        private var DATABASE_INSTANCE:AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context):AppRoomDatabase{
            if(DATABASE_INSTANCE!=null){
                return DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room
                .databaseBuilder(context.applicationContext,
                    AppRoomDatabase::class.java,
                    "spotify_database").fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}