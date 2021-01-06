package com.example.terbul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.terbul.database.penjualan
import com.example.terbul.database.penjualanrepositori
import com.example.terbul.database.penjualanviewmodel
import com.example.terbul.databinding.FragmentdialogPenjualanBinding
import kotlinx.android.synthetic.main.fragmentdialog_penjualan.*
class fragdialog_upjual(
    private val jual :penjualan
) : DialogFragment() {
    private lateinit var binding: FragmentdialogPenjualanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragmentdialog_penjualan,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        masukin()
        var penjualanviewmodel: penjualanviewmodel = ViewModelProviders.of(this).get(penjualanviewmodel::class.java)
        binding.btnupdateproduk.setOnClickListener{
            var upjual = penjualan(namapelpjl.text.toString(),deskpjl.text.toString(),tanggalpjl.text.toString(),totalpjl.text.toString().toInt())
            upjual.id_penjualan = jual.id_penjualan
            penjualanviewmodel.update(upjual)
            this.dismiss()
        }
    }
    fun masukin(){
        namapelpjl.setText(jual.namapelanggan)
        deskpjl.setText(jual.produk)
        tanggalpjl.setText(jual.tanggaljual)
        totalpjl.setText(jual.totalpembayaran.toString())
    }

}
