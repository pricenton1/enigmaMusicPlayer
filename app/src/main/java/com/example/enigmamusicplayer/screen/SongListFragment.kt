package com.example.enigmamusicplayer.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigmamusicplayer.R
import com.example.enigmamusicplayer.SongRecycleAdapter
import com.example.enigmamusicplayer.view_model.SongViewModel
import kotlinx.android.synthetic.main.fragment_song_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [SongListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongListFragment : Fragment(),View.OnClickListener {

    private val songViewModel by activityViewModels<SongViewModel>()
//    lateinit var adapter: SongRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_song_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        song_recycle_view.layoutManager = LinearLayoutManager(activity)
        songViewModel.getSongs().observe(viewLifecycleOwner, Observer {
            song_recycle_view.adapter = SongRecycleAdapter(it, activity)
        })

//        songViewModel.songLiveData.observe(viewLifecycleOwner, Observer{
//            adapter.notifyDataSetChanged()
//        })

        add_Button.setOnClickListener(this)
        navController = Navigation.findNavController(view)

    }

    override fun onClick(v: View?) {
        when(v){
            add_Button ->{navController.navigate(R.id.action_songListFragment_to_addSongFragment)}
        }
    }

}