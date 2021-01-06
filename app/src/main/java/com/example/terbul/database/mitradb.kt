package com.example.terbul.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [mitra::class], version = 1)
abstract class mitradb : RoomDatabase() {

    abstract fun mitradao(): mitradao
    companion object {
        private var instance: mitradb? = null
        fun getInstance(context: Context): mitradb? {
            if (instance == null) {
                synchronized(mitradb::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        mitradb::class.java, "mitra_database"  )
                        .fallbackToDestructiveMigration() .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }
        fun destroyInstance() {
            instance = null
        }
        private val roomCallback = object :
            RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }
    class PopulateDbAsyncTask(db:mitradb?) : AsyncTask<Unit, Unit, Unit>() {
        private val mitradao = db?.mitradao()

        override fun doInBackground(vararg p0: Unit?) {

        }
    }

}