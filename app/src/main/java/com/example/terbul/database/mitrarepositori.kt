package com.example.terbul.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData


class mitrarepositori(application: Application) {
    private var mitradao : mitradao
    private var allmitra: LiveData<List<mitra>>
    init {
        val database: mitradb = mitradb.getInstance(
            application.applicationContext
        )!!
        mitradao = database.mitradao()
        allmitra = mitradao.getAllmitra()
    }
    fun insert(mitra: mitra) {
        val insertmitraAsyncTask =
            InsertmitraAsyncTask(mitradao).execute(mitra)
    }
    fun update(mitra: mitra) {
        val updatemitraAsyncTask =
            UpdatemitraAsyncTask(mitradao).execute(mitra)
    }
    fun delete(mitra: mitra) {
        val deletemitraAsyncTask =
            DeletemitraAsyncTask(mitradao).execute(mitra)
    }
    fun getAllmitra(): LiveData<List<mitra>> {
        return allmitra
    }
    companion object {
        private class InsertmitraAsyncTask(mitradao: mitradao) :
            AsyncTask<mitra, Unit, Unit>() {
            val mitradao = mitradao
            override fun doInBackground(vararg p0: mitra?) {
                mitradao.insert(p0[0]!!)
            }
        }
        private class UpdatemitraAsyncTask(mitradao: mitradao) :
            AsyncTask<mitra, Unit, Unit>() {
            val mitradao= mitradao

            override fun doInBackground(vararg p0: mitra?) {
                mitradao.update(p0[0]!!)
            }
        }
        private class DeletemitraAsyncTask(mitradao: mitradao) :
            AsyncTask<mitra, Unit, Unit>() {
            val mitradao = mitradao

            override fun doInBackground(vararg p0: mitra?) {
                mitradao.delete(p0[0]!!)
            }
        }
    }
}