package com.eniola.studyapp.ui.subjects

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.eniola.studyapp.R
import com.eniola.studyapp.base.BaseFragment
import com.eniola.studyapp.ui.data.SubjectData
import com.eniola.studyapp.ui.subjects.adapters.SubjectListAdapter
import com.eniola.studyapp.utility.hide
import com.eniola.studyapp.utility.show
import com.eniola.studyapp.utility.toast
import kotlinx.android.synthetic.main.fragment_subject.*
import javax.inject.Inject

class SubjectFragment : BaseFragment(), SubjectListAdapter.SubjectClickedListener {

    //viewModel
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<SubjectViewModel> { viewModelFactory }

    private val adapter by lazy { SubjectListAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subject, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubjectFragment()
    }

    override fun observeData() {
        viewModel.state.observe(viewLifecycleOwner){viewState ->
            when (viewState) {
                is ViewState.SUCCESS -> {
                    loader.hide()
                    activity?.toast(viewState.message)
                    val subjectData = viewState.data
                    //populate subjects in recyclerview
                    populateSubjectInRecyclerView(subjectData)
                }

                is ViewState.ERROR -> {
                    activity?.toast(viewState.errorMessage)
                }

                is ViewState.LOADING -> {
                    loader.hide()
                    if(viewState.loading){
                        loader.show()
                    } else {
                        loader.hide()
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //offline conscious, fetch all subject from database

        //fetch data in viewModel
        viewModel.fetchAllSubject()
        observeData()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

    private fun populateSubjectInRecyclerView(dataList: List<SubjectData>){
        //set data-list in adapter
        adapter.setListItems(dataList)
        subjects_recyclerview.layoutManager = GridLayoutManager(
            context,2, GridLayoutManager.VERTICAL, false)
        subjects_recyclerview.adapter = adapter

    }

    override fun onSubjectClicked(view: View, item: SubjectData) {
        val bundle = Bundle()
        bundle.putParcelable("subject", item)
        //navigate to subject detail page showing all
        findNavController().navigate(R.id.go_to_detail_page, bundle)
    }

    override fun onResume() {
        super.onResume()
        //fetch data from database instead of API call

    }
}