package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.view_model.Song
import com.example.enigmamusicplayer.view_model.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddSongFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSongFragment : Fragment(),View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            save_button ->{
                songViewModel.addSong(Song(input_title.text.toString(),input_name.text.toString(),input_image.text.toString()))
                Toast.makeText(v?.context,"Song Added",Toast.LENGTH_SHORT).show()
            }
        }
    }
}