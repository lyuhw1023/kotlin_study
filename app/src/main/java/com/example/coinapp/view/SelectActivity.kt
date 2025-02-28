package com.example.coinapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coinapp.R
import com.example.coinapp.databinding.ActivitySelectBinding
import com.example.coinapp.view.adapter.SelectRVAdapter
import timber.log.Timber

class SelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectBinding

    private val viewModel : SelectViewModel by viewModels()

    //FAQ

    private lateinit var selectRvAdapter : SelectRVAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getCurrentCoinList()
        viewModel.currentPriceResult.observe(this, Observer {

            selectRvAdapter = SelectRVAdapter(this, it)

            binding.coinListRV.adapter = selectRvAdapter
            binding.coinListRV.layoutManager = LinearLayoutManager(this)

            Timber.d(it.toString())
        })

    }
}