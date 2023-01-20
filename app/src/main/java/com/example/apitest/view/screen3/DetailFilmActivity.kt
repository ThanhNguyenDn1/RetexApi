package com.example.apitest.view.screen3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apitest.data.model.Datum
import com.example.apitest.databinding.ActivityDetailFilmBinding
import com.example.apitest.utils.Constant
import com.example.apitest.utils.stringToDatum

class DetailFilmActivity : AppCompatActivity() {
    private var item: Datum? = null
    private lateinit var binding: ActivityDetailFilmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupData()
        setupView()
        handlerEvent()
    }

    private fun handlerEvent() {
        binding.imvBack.setOnClickListener {
            finish()
        }
    }

    private fun setupView() {
        item?.let {
            binding.apply {
                tvTitle.text = it.title
                tvAuthor.text = it.author
                tvDatetimee.text = it.datetime
                tvDescription.text = it.description
            }
        }
    }

    private fun setupData() {
        val jsonFilm = intent.getStringExtra(Constant.JSON_DATUM)
        item = jsonFilm?.stringToDatum()
    }
}