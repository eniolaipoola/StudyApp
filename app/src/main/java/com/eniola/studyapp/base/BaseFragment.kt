package com.eniola.studyapp.base

import dagger.android.support.DaggerFragment

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 19-Jan-2021
 */

abstract class BaseFragment : DaggerFragment(){
    abstract fun observeData()
}