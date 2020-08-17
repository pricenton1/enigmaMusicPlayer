package com.example.enigmamusicplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.view_model.Song
import com.example.enigmamusicplayer.view_model.SongViewModel
import com.squareup.picasso.Picasso

class SongRecycleAdapter(private val songList: List<Song>, private val getActivity: FragmentActivity?): RecyclerView.Adapter<SongViewHolder>() {

    lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_recycle_item_layout,parent,false)
        return SongViewHolder(view)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.songTitle.text = songList[position].title
        holder.artisName.text = songList[position].artis
        Picasso.with(getActivity).load(songList[position].image).into(holder.imageSong)

        val bundle = bundleOf(Pair("position",position))
        holder.itemView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_songListFragment_to_songDetailFragment,bundle)
        }
    }
}

class SongViewHolder(v:View):RecyclerView.ViewHolder(v),View.OnClickListener{

    val songTitle = v.findViewById<TextView>(R.id.song_title_text)
    val artisName = v.findViewById<TextView>(R.id.artis_text)
    val imageSong:ImageView = v.findViewById(R.id.image_song)

    override fun onClick(v: View?) {
        when(v){
            itemView -> {
                Toast.makeText(v?.context,"${songTitle.text} is Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}