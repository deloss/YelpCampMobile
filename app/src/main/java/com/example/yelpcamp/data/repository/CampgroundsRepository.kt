package com.example.yelpcamp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.api.APIClient
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CampgroundsRepository(private val compositeDisposable: CompositeDisposable) {

    val apiClient = APIClient.getClient()

    fun fetchCampgrounds() : LiveData<List<Campground>> {
        val campgroundsList = MutableLiveData<List<Campground>>()
        compositeDisposable.add(apiClient.getCampgrounds().subscribeOn(Schedulers.io()).subscribe(
            {
                campgroundsList.postValue(it)
            },
            {
                Log.e("CampgroundsRepository", it.message)
            }
        ))
        return campgroundsList
    }


}