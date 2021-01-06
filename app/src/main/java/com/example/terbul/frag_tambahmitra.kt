package com.example.terbul

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.terbul.database.mitra
import com.example.terbul.database.mitraviewmodel
import com.example.terbul.databinding.FragmentTambahmitraBinding
import kotlinx.android.synthetic.main.fragment_tambahmitra.*

class frag_tambahmitra : Fragment() {
    private lateinit var binding: FragmentTambahmitraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tambahmitra,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mitraviewmodel: mitraviewmodel = ViewModelProviders.of(this).get(mitraviewmodel::class.java)
        if (arguments != null) {
            masukin()
        }
        binding.savemitra.setOnClickListener{
            if (arguments != null) {
                //masukin()
                var idt = arguments?.getInt("id")
                val newmitra = mitra (
                    binding.namamitra.text.toString(),binding.deskmitra.text.toString(),binding.emailmitra.text.toString(),binding.notelpmit.text.toString()
                    ,binding.alamatmitra.text.toString()
                )
                newmitra.id_mitra = idt.toString().toInt()
                mitraviewmodel.update(newmitra)
                //this.dismiss()
                this.findNavController().popBackStack()
            }
            else{
                val newmitra = mitra (
                    binding.namamitra.text.toString(),binding.deskmitra.text.toString(),binding.emailmitra.text.toString(),binding.notelpmit.text.toString()
                    ,binding.alamatmitra.text.toString()
                )
                mitraviewmodel.insert(newmitra)
                //this.dismiss()
                this.findNavController().popBackStack()
            }

        }

    }
    fun masukin(){

        namamitra.setText(arguments?.getString("namamitra").toString())
        deskmitra.setText(arguments?.getString("desk").toString())
        emailmitra.setText(arguments?.getString("email").toString())
        notelpmit.setText(arguments?.getString("notelp").toString())
        alamatmitra.setText(arguments?.getString("alamat").toString())
    }
}
