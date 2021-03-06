package com.example.terbul.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface Produkdao {

    @Insert
    fun insert(produk: produk)

    @Update
    fun update(produk: produk)

    @Delete
    fun delete(produk: produk)

    @Query("SELECT * FROM tabel_produk")
    fun getAllproduk(): LiveData<List<produk>>

}
@Dao
interface Pelanggandao {

    @Insert
    fun insert(pelanggan: pelanggan)

    @Update
    fun update(pelanggan: pelanggan)

    @Delete
    fun delete(pelanggan: pelanggan)

    @Query("SELECT * FROM tabel_pelanggan")
    fun getAllpelanggan(): LiveData<List<pelanggan>>

}
@Dao
interface Penjualandao {

    @Insert
    fun insert(penjualan: penjualan)

    @Update
    fun update(penjualan: penjualan)

    @Delete
    fun delete(penjualan: penjualan)

    @Query("SELECT * FROM tabel_penjualan")
    fun getAllpenjualan(): LiveData<List<penjualan>>

}


@Dao
interface tempprodukDao {
    @Query("SELECT * from tabel_tempproduk")
    fun alldatatempproduk(): LiveData<List<tempproduk>>

    @Query("SELECT * from tabel_tempproduk")
    fun alldatatemp(): List<tempproduk>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tempproduk: tempproduk)

    @Delete
    suspend fun delete(tempproduk: tempproduk)

    @Query("DELETE FROM  tabel_tempproduk")
    suspend fun deleteALLtempproduk()
}
@Dao
interface mitradao {

    @Insert
    fun insert(mitra: mitra)

    @Update
    fun update(mitra: mitra)

    @Delete
    fun delete(mitra: mitra)

    @Query("SELECT * FROM tabel_mitra")
    fun getAllmitra(): LiveData<List<mitra>>

}

@Dao
interface pembeliandao {

    @Insert
    fun insert(pembelian: pembelian)

    @Update
    fun update(pembelian : pembelian)

    @Delete
    fun delete(pembelian: pembelian)

    @Query("SELECT * FROM tabel_pembelian")
    fun getAllpembelian(): LiveData<List<pembelian>>

}
@Dao
interface temppesprodukDao {
    @Query("SELECT * from tabel_temppesproduk")
    fun alldatatemppesproduk(): LiveData<List<temppesproduk>>

    @Query("SELECT * from tabel_temppesproduk")
    fun alldatatemppes(): List<temppesproduk>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(temppesproduk: temppesproduk)

    @Delete
    suspend fun delete(temppesproduk: temppesproduk)

    @Query("DELETE FROM  tabel_temppesproduk")
    suspend fun deleteALLtemppesproduk()
}

