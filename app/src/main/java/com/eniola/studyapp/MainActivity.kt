package com.eniola.studyapp

import android.os.Bundle
import com.eniola.studyapp.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}