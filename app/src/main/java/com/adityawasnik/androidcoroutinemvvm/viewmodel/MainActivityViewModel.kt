package com.adityawasnik.androidcoroutinemvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adityawasnik.androidcoroutinemvvm.model.RecycleList
import com.adityawasnik.androidcoroutinemvvm.network.RetroService
import com.adityawasnik.androidcoroutinemvvm.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    lateinit var recyclerListLiveData : MutableLiveData<RecycleList>


    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<RecycleList> {
        return recyclerListLiveData
    }

    fun makeApiApiCall() {
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetrofitInstance.getRetroInstance().create(RetroService::class.java)
            val response = retroInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }


}