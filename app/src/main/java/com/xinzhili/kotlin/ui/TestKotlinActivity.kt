package com.xinzhili.kotlin.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xinzhili.doctor.R
import com.xinzhili.doctor.base.BaseActivity
import kotlinx.android.synthetic.main.activity_test_kotlin.*

class TestKotlinActivity : BaseActivity() {

    companion object{
        @JvmStatic
        fun actionStart(context: Context, name:String) = Intent().run {
            putExtra("NAME", name)
            setClass(context, TestKotlinActivity::class.java)
            context.startActivity(this)
        }
    }

    override fun getLayoutId() = R.layout.activity_test_kotlin

    override fun initViews() {
        init()
    }

    override fun initData() {
        toolbar.setLeftClick { finish() }
            .setTitle("kotlin页面")
    }
    fun init(){
        val name = intent?.getStringExtra("NAME")
        name?.let {
            tvTest.text = it
        }
    }


}
