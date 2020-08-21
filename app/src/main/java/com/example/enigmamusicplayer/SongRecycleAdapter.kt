package com.example.enigmamusicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.room.song.Song
import org.w3c.dom.Text

class SongRecycleAdapter(private val songList:List<Song>):RecyclerView.Adapter<SongViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_recycle_item_layout, parent, false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = songList[position].songName
        holder.songDuration.text = songList[position].songDuration

        holder.imageSongPlay.setOnClickListener(holder)
    }

}

class SongViewHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{
    val songTitle = view.findViewById<TextView>(R.id.song_title_text)
    val songDuration = view.findViewById<TextView>(R.id.song_duration_text)
    val imageSongPlay = view.findViewById<ImageView>(R.id.image_song_text)

    override fun onClick(v: View?) {
        when(v){
            imageSongPlay -> {
                imageSongPlay.setImageResource(R.drawable.ic_baseline_pause_24)
            }
        }
    }
}