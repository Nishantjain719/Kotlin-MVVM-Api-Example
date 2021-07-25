package com.example.kotlincoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kotlincoroutines.models.User
import com.example.kotlincoroutines.repository.Repository

class MainViewModel : ViewModel(){

    private val _userId: MutableLiveData<String> = MutableLiveData()

    // if obj _userId changes, this switchMap operator will trigger. we map from one obj type(string) to another obj type(Livedata user obj)
    val user: LiveData<User> = Transformations
        .switchMap(_userId){userId ->
            Repository.getUser(userId)
        }

    fun setUser(userId: String){
        val update = userId
        if(_userId.value == update){
            return
        }
        _userId.value = update
    }

    fun cancelJobs(){
        Repository.cancelJobs()
    }
}