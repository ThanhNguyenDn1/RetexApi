package com.example.apitest.view.screen2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitest.adapter.Adapter
import com.example.apitest.data.model.Datum
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.utils.Constant
import com.example.apitest.utils.Status
import com.example.apitest.utils.filmToString
import com.example.apitest.view.screen3.DetailFilmActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Adapter.OnClick {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupData()
        setupView()
    }

    private fun setupView() {
        viewModel.getFilms().observe(this) {
            when (it.status) {
                Status.LOADING -> binding.tvLoading.visibility = View.VISIBLE
                Status.SUCCESS -> binding.tvLoading.visibility = View.GONE
                else -> binding.tvError.visibility = View.VISIBLE
            }
            it.data?.let {
                adapter.setItems(it.data!!)
            }
        }
    }

    private fun setupData() {
        adapter = Adapter(this)
        binding.list.apply {
            adapter = this@MainActivity.adapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }
        viewModel.getFilmFromAPI()
    }

    override fun onclickFilm(item: Datum) {
        val jsonDatum = item.filmToString()
        val intent = Intent(this, DetailFilmActivity::class.java)
        intent.putExtra(Constant.JSON_DATUM, jsonDatum)
        startActivity(intent)
    }
}