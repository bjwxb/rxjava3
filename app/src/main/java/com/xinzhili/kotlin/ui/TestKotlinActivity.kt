package com.xinzhili.kotlin.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xinzhili.doctor.R
import kotlinx.android.synthetic.main.activity_test_kotlin.*

class TestKotlinActivity : AppCompatActivity() {

    companion object{
        @JvmStatic
        fun actionStart(context: Context, name:String) = Intent().run {
            putExtra("NAME", name)
            setClass(context, TestKotlinActivity::class.java)
            context.startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kotlin)

        init()
    }

    fun init(){
        val name = intent?.getStringExtra("NAME")
        name?.let {
            tvTest.text = it
        }
    }


}
