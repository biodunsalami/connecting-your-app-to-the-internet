package com.biodun.connectingyourapptotheinternet.fragments.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biodun.connectingyourapptotheinternet.api.Character
import com.biodun.connectingyourapptotheinternet.api.Repository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel (private val repository: Repository): ViewModel() {

    private val _charactersLiveData = MutableLiveData<List<Character>>()

    private val TAG = MainViewModel::class.java.simpleName

    val charactersLiveData:LiveData<List<Character>>
    get() = _charactersLiveData

    init {
        getCharacters()
    }

    private fun getCharacters(){
        viewModelScope.launch {
            try{
                _charactersLiveData.value = repository.getCharacters().character
                Log.d(TAG, "${_charactersLiveData.value}")
            }catch (e:Exception){
                Log.e(TAG, e.message.toString())
            }

        }

    }
}