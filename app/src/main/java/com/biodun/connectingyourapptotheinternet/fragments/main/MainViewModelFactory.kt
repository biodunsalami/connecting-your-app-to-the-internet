package com.biodun.connectingyourapptotheinternet.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.biodun.connectingyourapptotheinternet.api.Repository
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("UNKNOWN CLASS")
        }
    }
}