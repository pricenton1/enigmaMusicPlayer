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
import androidx.recyclerview.widget.RecyclerView
import com.example.enigmamusicplayer.room.artist.Artist
import com.squareup.picasso.Picasso

class ArtistRecycleAdapter(private val artistList: List<Artist>, private val getActivity: FragmentActivity?): RecyclerView.Adapter<ArtistViewHolder>() {

//    lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.artist_recycle_item_layout,parent,false)
        return ArtistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.albumName.text = artistList[position].album
        holder.artisName.text = artistList[position].name
        Picasso.with(getActivity).load(artistList[position].image).into(holder.imageArtist)

        val bundle = bundleOf(
            Pair("album", artistList[position].album), Pair("image", artistList[position].image),
            Pair("idArtist", artistList[position].idArtist.toString())
        )
        holder.itemView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_songListFragment_to_songDetailFragment,bundle)
        }
    }
}

class ArtistViewHolder(v:View):RecyclerView.ViewHolder(v){

    val albumName = v.findViewById<TextView>(R.id.album_name_text)
    val artisName = v.findViewById<TextView>(R.id.artis_name_text)
    val imageArtist:ImageView = v.findViewById(R.id.image_artist)
}