package com.example.terbul

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.terbul.database.mitra
import kotlinx.android.synthetic.main.item_mitra.view.*


class mitraadpter : ListAdapter<mitra, mitraadpter.mitraHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<mitra>() {
            override fun areItemsTheSame(oldItem: mitra, newItem: mitra): Boolean {
                return oldItem.id_mitra == newItem.id_mitra
            }
            override fun areContentsTheSame(oldItem: mitra, newItem: mitra): Boolean {
                return oldItem.namamitra == newItem.namamitra
                        && oldItem.emailmitra == newItem.emailmitra
                        && oldItem.notelpmit == newItem.notelpmit
                        && oldItem.deskmitra == newItem.deskmitra
                        && oldItem.alamatmit == newItem.alamatmit
            }
        }
    }
    private var listener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mitraHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mitra, parent, false)
        return mitraHolder(itemView)
    }
    override fun onBindViewHolder(holder: mitraHolder, position: Int) {
        val currentmitra: mitra = getItem(position)
        holder.textViewnama.text = currentmitra.namamitra
        holder.textViewdesk.text = currentmitra.deskmitra
    }
    fun getmitraAt(position: Int): mitra {
        return getItem(position)
    }
    inner class mitraHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }
        var textViewnama: TextView = itemView.nama_mitra
        var textViewdesk: TextView = itemView.deskmitra
    }
    interface OnItemClickListener {
        fun onItemClick(mitra: mitra)
    }
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}