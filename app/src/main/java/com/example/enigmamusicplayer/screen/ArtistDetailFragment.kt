package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.SongRecycleAdapter
import com.example.enigmamusicplayer.SongViewHolder
import com.example.enigmamusicplayer.view_model.artist.ArtistViewModel
import com.example.enigmamusicplayer.view_model.song.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_artist_detail.*
import kotlinx.android.synthetic.main.fragment_artist_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [ArtistDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArtistDetailFragment : Fragment() {

    val artistViewModel by activityViewModels<ArtistViewModel>()
    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idArtist = arguments?.getInt("idArtist") ?:0

        artistViewModel.getArtistById(idArtist).observe(viewLifecycleOwner, Observer {
            title_detail.text = arguments?.getString("album")
            Picasso.with(activity).load(arguments?.getString("image")).into(image_detail)
        })

        song_recycle_view.layoutManager = LinearLayoutManager(activity)
        songViewModel.getSongWithArtistId(idArtist).observe(viewLifecycleOwner, Observer {
            song_recycle_view.adapter = SongRecycleAdapter(it)
        })

        add_song_button.setOnClickListener {
            val bundle = bundleOf(Pair("idArtist", idArtist))
            Navigation.findNavController(it)
                .navigate(R.id.action_songDetailFragment_to_addSongFragment2, bundle)
        }

    }
}