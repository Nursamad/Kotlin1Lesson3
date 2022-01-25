package com.example.kotlin1lesson3

import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import com.example.kotlin1lesson3.base.BaseActivity
import com.example.kotlin1lesson3.base.BaseViewModel
import com.example.kotlin1lesson3.databinding.ActivityMainBinding

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    private var list = arrayListOf<String>()

    override fun initView() {
        super.initView()

    }

    override fun initListener() {
        super.initListener()
        binding.edtInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                list.add(binding.edtInput.text.toString())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        binding.btnClick.setOnClickListener {
            list.forEach {
                binding.tvDisplay.append(it + "\n")
            }
            list.clear()
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

}