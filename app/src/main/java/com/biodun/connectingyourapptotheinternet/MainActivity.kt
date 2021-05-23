package com.biodun.connectingyourapptotheinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.biodun.connectingyourapptotheinternet.api.Api
import com.biodun.connectingyourapptotheinternet.api.Character
import com.biodun.connectingyourapptotheinternet.api.Repository
import com.biodun.connectingyourapptotheinternet.databinding.ActivityMainBinding
import com.biodun.connectingyourapptotheinternet.fragments.main.MainAdapter
import com.biodun.connectingyourapptotheinternet.fragments.main.MainViewModel
import com.biodun.connectingyourapptotheinternet.fragments.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: MainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel : MainViewModel by lazy {
            ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService)))
                .get(MainViewModel::class.java)
        }

        binding.characterRv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        binding.characterRv.layoutManager = LinearLayoutManager(this)

        viewModel.charactersLiveData.observe(this, Observer {
            adapter = MainAdapter(it)
            binding.characterRv.adapter = adapter
            binding.progressTing.visibility = View.GONE
        })

    }
}