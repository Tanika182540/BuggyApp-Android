package scb.academy.jinglebell.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import scb.academy.jinglebell.R
import scb.academy.jinglebell.activity.ProfileActivity
import scb.academy.jinglebell.activity.SongInfoActivity
import scb.academy.jinglebell.adapter.OnSongClickListener
import scb.academy.jinglebell.adapter.SongAdapter
import scb.academy.jinglebell.extension.showToast
import scb.academy.jinglebell.model.DataSong
import scb.academy.jinglebell.model.Song
import scb.academy.jinglebell.model.SongSearchResult
import scb.academy.jinglebell.service.ApiManager

class ProfileFragment : Fragment(){


    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_profile, container, false)

        _view.textView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                val name = _view.textView.text
                val intent = Intent (activity, ProfileActivity::class.java)

                intent.putExtra("nameText",name)
                startActivity(intent)
                return@OnKeyListener true
            }
            false
        })
        return _view

    }

}
