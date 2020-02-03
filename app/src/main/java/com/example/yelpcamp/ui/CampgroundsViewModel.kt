package com.example.yelpcamp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.yelpcamp.data.repository.CampgroundsRepository
import io.reactivex.disposables.CompositeDisposable

class CampgroundsViewModel(repository : CampgroundsRepository) : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    val campgroundsList : LiveData<List<Campground>> by lazy {
        repository.fetchCampgrounds()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}