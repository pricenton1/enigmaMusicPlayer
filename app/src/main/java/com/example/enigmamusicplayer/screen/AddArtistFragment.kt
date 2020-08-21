package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.artist.Artist
import com.example.enigmamusicplayer.view_model.artist.ArtistViewModel
import kotlinx.android.synthetic.main.fragment_add_artist.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddArtistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddArtistFragment : Fragment(),View.OnClickListener {

    val artistViewModel by activityViewModels<ArtistViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            save_button ->{
                val album = input_title.text.toString()
                val name = input_name.text.toString()
                val image = input_image.text.toString()

                artistViewModel.createNewArtist(
                    Artist(album = album,name = name,image = image))
                Toast.makeText(v?.context,"Artist Added",Toast.LENGTH_SHORT).show()
            }
        }
    }
}