package com.example.apitest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apitest.data.model.Datum
import com.example.apitest.databinding.ItemLayoutBinding

class Adapter(private val onClick: OnClick) : RecyclerView.Adapter<Adapter.FilmHolder>() {

    class FilmHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    private var items: List<Datum> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.let {
                    it.tvTitle.text = this.title.toString()
                    it.tvAuthor.text = this.author.toString()
                    it.tvDatetimee.text = this.datetime.toString()
                    it.root.setOnClickListener { onClick.onclickFilm(this) }
                }
            }
        }

    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Datum>) {
        this.items = items
        notifyDataSetChanged()
    }

    interface OnClick {
        fun onclickFilm(item: Datum)
    }
}