package com.project.liceriabakery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.liceriabakery.data.MainRepository
import com.project.liceriabakery.data.entity.MainEntity

class MainViewModel(private val mainRepository: MainRepository):ViewModel() {

fun getBakery():LiveData<List<MainEntity>> = mainRepository.listBakery()
}
class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}