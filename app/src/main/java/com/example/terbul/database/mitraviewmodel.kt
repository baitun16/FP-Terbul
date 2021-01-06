package com.example.terbul.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData


class mitraviewmodel(application: Application) : AndroidViewModel(application) {

    private var repository: mitrarepositori = mitrarepositori(application)
    private var allmitra: LiveData<List<mitra>> = repository.getAllmitra()
    fun insert(mitra: mitra) {
        repository.insert(mitra)
    }
    fun update(mitra: mitra) {
        repository.update(mitra)
    }
    fun delete(mitra: mitra) {
        repository.delete(mitra)
    }

    fun getAllmitra(): LiveData<List<mitra>> {
        return allmitra
    }
}