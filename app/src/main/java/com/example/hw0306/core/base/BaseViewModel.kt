package com.example.hw0306.core.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    val loading = MutableLiveData<Boolean>()
}
