package com.example.terbul

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.terbul.database.mitra
import com.example.terbul.database.mitraviewmodel
import com.example.terbul.databinding.FragmentMitraBinding
import kotlinx.android.synthetic.main.fragment_mitra.*
import kotlinx.android.synthetic.main.fragment_tambahmitra.*

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
class frag_mitra : Fragment() {

    private lateinit var binding: FragmentMitraBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mitra,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_mitra.layoutManager = LinearLayoutManager(this.requireContext())
        rv_mitra.setHasFixedSize(true)
        val adapter = mitraadpter()
        rv_mitra.adapter = adapter

        var mitraviewmodel: mitraviewmodel = ViewModelProviders.of(this).get(mitraviewmodel::class.java)
        mitraviewmodel.getAllmitra() .observe(this.viewLifecycleOwner, Observer <List<mitra>>{
            adapter.submitList(it)
        })

        binding.buttonAddmitra.setOnClickListener{
            it.findNavController().navigate(R.id.action_frag_mitra_to_frag_tambahmitra)
        }

        ItemTouchHelper(
            object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT).or(
                    ItemTouchHelper.DOWN)) {
                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                    return false
                }
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    AlertDialog.Builder(viewHolder.itemView.getContext())
                        // Judul
                        .setTitle("Warning")
                        // Pesan yang di tampilkan
                        .setMessage("Ingin Dihapus ?")
                        .setPositiveButton("Ya", DialogInterface.OnClickListener(){ dialogInterface, i ->
                            mitraviewmodel.delete(adapter.getmitraAt(viewHolder.adapterPosition))

                            Toast.makeText(activity, "Mitra dihapus!", Toast.LENGTH_SHORT).show()
                        })
                        .setNegativeButton("Tidak", DialogInterface.OnClickListener { dialogInterface, i ->
                            Toast.makeText(activity, "Mitra Tidak Terhapus", Toast.LENGTH_SHORT).show()

                            adapter.notifyItemChanged(viewHolder.adapterPosition)
                        })
                        .show()
                }
            }
        ).attachToRecyclerView(rv_mitra)
        adapter.setOnItemClickListener(object : mitraadpter.OnItemClickListener {
            override fun onItemClick(mitra: mitra) {
                if (arguments != null) {
                    val bundle = Bundle()
                    bundle.putString("namamitra", mitra.namamitra)
                    bundle.putString("email", mitra.emailmitra)
                    when (view.id) {
                        R.id.listmitra -> {

                            view.findNavController().navigate(
                                R.id.frag_tambahpembelian, bundle)
                        }
                    }
                }
                else{//update
                    val bundle = Bundle()
                    bundle.putInt("id",mitra.id_mitra)
                    bundle.putString("namamitra",mitra.namamitra)
                    bundle.putString("desk",mitra.deskmitra)
                    bundle.putString("email", mitra.emailmitra)
                    bundle.putString("notelp",mitra.notelpmit)
                    bundle.putString("alamat",mitra.alamatmit)

                    view.findNavController().navigate(R.id.action_frag_mitra_to_frag_tambahmitra, bundle)
                }
            }
        }
        )}

}
