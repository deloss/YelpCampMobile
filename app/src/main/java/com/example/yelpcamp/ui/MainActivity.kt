package com.example.yelpcamp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yelpcamp.R
import com.example.yelpcamp.data.repository.CampgroundsRepository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var campgroundList : List<Campground> = ArrayList<Campground>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campgorundViewModel = getViewModel()

        val campgroundAdapter = CampgroundAdapter(campgroundList)
        campgroundsList.layoutManager = LinearLayoutManager(this)
        campgroundsList.setHasFixedSize(false)
        campgroundsList.adapter = campgroundAdapter

        campgorundViewModel.campgroundsList.observe(this, Observer {
            campgroundList = it
            campgroundAdapter.campgrounds = it
            campgroundAdapter.notifyDataSetChanged()
        })

    }

    private fun getViewModel() : CampgroundsViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CampgroundsViewModel(CampgroundsRepository(CompositeDisposable())) as T
            }

        })[CampgroundsViewModel::class.java]
    }
}
