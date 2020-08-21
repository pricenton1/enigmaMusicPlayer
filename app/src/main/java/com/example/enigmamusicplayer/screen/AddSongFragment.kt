package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.room.song.Song
import com.example.enigmamusicplayer.view_model.song.SongViewModel
import kotlinx.android.synthetic.main.fragment_add_song.*

/**
 * A simple [Fragment] subclass.
 * Use the [AddSongFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddSongFragment : Fragment() {

    private val songViewModel by activityViewModels<SongViewModel>()

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

        val idArtist = arguments?.getInt("idArtist") ?: 0
        save_song_button.setOnClickListener{
            val title = input_song_title.text.toString()
            val duration = input_duration.text.toString()

            if (title == "" || duration == ""){
                Toast.makeText(context,"Input Empty", Toast.LENGTH_SHORT).show()
            }else{
                songViewModel.createNewSong(Song(songName = title,songDuration = duration,songArtistId = idArtist))
                Navigation.findNavController(view).navigate(R.id.action_addSongFragment2_pop)
                Toast.makeText(context,"Song Added",Toast.LENGTH_SHORT).show()
            }
        }
    }

}