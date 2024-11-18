package com.android.learning

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init(savedInstanceState)
    }

    private fun init(savedInstanceState: Bundle?) {
        initView()
        initListener()
        bindVM()
    }


    private fun initView() {
        //Những thứ liên quan về view
        binding.tvClickThis.text = String.format(getString(R.string.has_click_times), 0)

    }

    private fun initListener() {
        //Những thứ liên quan về hoạt động (ví  dụ : click,  chuyển màn ,...)
        binding.tvClickThis.setOnClickListener {
            viewModel.onButtonClick()
        }
    }

    private fun bindVM() {
        viewModel.numberTimesClicked.observe(this) {
            binding.tvClickThis.text = String.format(getString(R.string.has_click_times), it)
        }
    }

}
