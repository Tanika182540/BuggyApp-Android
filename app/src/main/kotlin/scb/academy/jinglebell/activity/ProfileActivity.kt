package scb.academy.jinglebell.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.item_country.*
import scb.academy.jinglebell.R
import scb.academy.jinglebell.fragment.CountryListFragment
import scb.academy.jinglebell.fragment.ProfileFragment
import scb.academy.jinglebell.fragment.SongListFragment

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nametv = intent.getStringExtra("nameText")
        Toast.makeText(this, nametv, Toast.LENGTH_SHORT).show()
        textViewName.text = nametv
    }


}
