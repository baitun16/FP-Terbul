package com.example.terbul.database

import androidx.lifecycle.LiveData


class tempprodukrepositori(private val tempprodukDao: tempprodukDao){

    val alltemps: LiveData<List<tempproduk>> = tempprodukDao.alldatatempproduk()
    //val sumhartot: LiveData<List<tempproduk>> = tempprodukDao.getsum()
    suspend fun insert(tempproduk: tempproduk){
        tempprodukDao.insert(tempproduk)
    }

    suspend fun delete(tempproduk: tempproduk){

        tempprodukDao.delete(tempproduk)
    }
    suspend fun deleteALLtempproduk(){
        tempprodukDao.deleteALLtempproduk()
    }

}