package com.example.hw0306.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding


abstract class BaseActivity<DB : ViewBinding/*, VM : BaseViewModel*/>(
    //  @LayoutRes private val layoutId: Int,
    //  private val viewModelClass: Class<VM>
) : AppCompatActivity() {
    private lateinit var binding: DB
    abstract fun inflateViewBinding(): DB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        initView()
        initListener()

    }

    open fun initListener() {}

    open fun initView() {}

    open fun setupLiveData () {}
    open fun setUI (){}
    open fun checkInternet (){}



}