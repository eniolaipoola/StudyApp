package com.eniola.studyapp.di

import androidx.lifecycle.ViewModel
import com.eniola.studyapp.MainActivity
import com.eniola.studyapp.ui.subjects.SubjectFragment
import com.eniola.studyapp.ui.subjects.SubjectViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Copyright (c) 2021 Eniola Ipoola
 * All rights reserved
 * Created on 20-Jan-2021
 */

@Module
abstract class MainModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun subjectFragment(): SubjectFragment

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(SubjectViewModel::class)
    internal abstract fun subjectFragmentViewModel(viewModel: SubjectViewModel): ViewModel
}