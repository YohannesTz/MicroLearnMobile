package com.yohannes.app.microlearn.activities.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the profile fragment"
    }

    val text: LiveData<String> = _text
}