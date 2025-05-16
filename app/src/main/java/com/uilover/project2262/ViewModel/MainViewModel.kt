package com.uilover.project2262.ViewModel

import androidx.lifecycle.LiveData
import com.uilover.project2262.Domain.FlightModel
import com.uilover.project2262.Domain.LocationModel
import com.uilover.project2262.Repository.MainRepository

class MainViewModel {

    private val repository = MainRepository()

    fun loadLocations(): LiveData<MutableList<LocationModel>> {
        return repository.loadLocation()
    }

    fun loadFiltered(from: String, to: String):
            LiveData<MutableList<FlightModel>> {
        return repository.loadFiltered(from, to)
    }

//    fun loadAuth() : LiveData<MutableList<AuthModel>> {
//        return repository.loadAuth()
//    }
}