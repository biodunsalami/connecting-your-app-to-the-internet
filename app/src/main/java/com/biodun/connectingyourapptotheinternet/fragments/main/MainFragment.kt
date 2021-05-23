//package com.biodun.connectingyourapptotheinternet.fragments.main
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.biodun.connectingyourapptotheinternet.api.Api
//import com.biodun.connectingyourapptotheinternet.api.Character
//import com.biodun.connectingyourapptotheinternet.api.Repository
//import com.biodun.connectingyourapptotheinternet.databinding.FragmentMainBinding
//
//class MainFragment : Fragment() {
//
//    private var binding: FragmentMainBinding? = null
//
//    private val characters = mutableListOf<Character>()
//
//    private val viewModel : MainViewModel by lazy {
//        ViewModelProvider(this, MainViewModelFactory(Repository(Api.apiService)))
//            .get(MainViewModel::class.java)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentMainBinding.inflate(layoutInflater)
//        return binding?.root
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//
//        viewModel.charactersLiveData.observe(this, Observer {
//            characters.addAll(it)
//        })
//
//        val adapter = MainAdapter(characters)
////        binding?.characterRv?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        binding?.characterRv?.layoutManager = LinearLayoutManager(context)
//        binding?.characterRv?.adapter = adapter
//    }
//
//}