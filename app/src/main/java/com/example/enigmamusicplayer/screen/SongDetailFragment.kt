package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.view_model.SongViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_song_detail.*
import kotlinx.android.synthetic.main.song_recycle_item_layout.*

/**
 * A simple [Fragment] subclass.
 * Use the [SongDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongDetailFragment : Fragment() {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt("position") ?: 0
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            title_detail.text = it[position].title
            Picasso.with(activity).load(it[position].image).into(image_detail)
        })
    }
}