package scb.academy.jinglebell.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import scb.academy.jinglebell.activity.SongInfoActivity
import scb.academy.jinglebell.adapter.OnSongClickListener
import scb.academy.jinglebell.adapter.SongAdapter
import scb.academy.jinglebell.extension.showToast
import scb.academy.jinglebell.model.DataSong
import scb.academy.jinglebell.model.Song
import scb.academy.jinglebell.model.SongSearchResult
import scb.academy.jinglebell.service.ApiManager
import android.R



class SongListFragment : Fragment(), OnSongClickListener {

    private var mDataArray: ArrayList<Song> = ArrayList<Song>()
    private lateinit var rvSongs: RecyclerView
    private lateinit var songAdapter: SongAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(scb.academy.jinglebell.R.layout.fragment_song_list, container, false)
    }

    private val songListCallback = object : Callback<SongSearchResult> {
        override fun onFailure(call: Call<SongSearchResult>, t: Throwable) {
            context?.showToast("Can not call country list $t")
        }

        override fun onResponse(call: Call<SongSearchResult>, response: Response<SongSearchResult>) {
            context?.showToast("Success")
            if(response.isSuccessful){
                mDataArray.clear()
                mDataArray.addAll(response.body()!!.results)
                Log.d("SCB_NETWORK",mDataArray.toString())

                songAdapter.notifyDataSetChanged()
                songAdapter.submitList(mDataArray)
            }

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvSongs = view.findViewById(scb.academy.jinglebell.R.id.rv_rooms)
        songAdapter = SongAdapter(this)
        rvSongs.adapter = songAdapter
        rvSongs.layoutManager = LinearLayoutManager(context)
        rvSongs.itemAnimator = DefaultItemAnimator()
        rvSongs.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        loadSongs()
    }

    private fun loadSongs()  {
        ApiManager.artistService.songs().enqueue(songListCallback)
    }

    override fun onSongClick(song: Song) {
        val intent = Intent (getActivity(), SongInfoActivity::class.java)
        //intent.putParcelableArrayListExtra("song",mDataArray)
        intent.putExtra("song",song)
        startActivity(intent)
    }
}
