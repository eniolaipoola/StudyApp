package com.eniola.studyapp.ui.subjects

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eniola.studyapp.R
import com.eniola.studyapp.ui.data.Lessons
import com.eniola.studyapp.ui.data.SubjectData
import com.eniola.studyapp.ui.subjects.adapters.ChaptersAdapter
import com.eniola.studyapp.ui.subjects.adapters.LessonsAdapter
import kotlinx.android.synthetic.main.fragment_subject_detail.*

class SubjectDetailFragment : Fragment(), LessonsAdapter.LessonClickedListener {

    private val chapterAdapter by lazy { ChaptersAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_subject_detail, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SubjectDetailFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        back_button.setOnClickListener {
            findNavController().navigateUp()
        }

        //GET PASSED subject bundle
        val bundle = arguments
        if(bundle != null){
            val subjectItem = bundle.getParcelable<SubjectData>("subject")
            Log.d("tag", "subject name is " + subjectItem?.name)

            val subjectName = subjectItem?.name
            val allChapters = subjectItem?.chapters

            subject_name.text = subjectName

            //set chapters in a linear layout
            allChapters?.let { chapterAdapter.setListItems(it) }
            chapters_recyclerview.layoutManager = LinearLayoutManager(context)
            chapters_recyclerview.adapter = chapterAdapter

        }

    }

    override fun onLessonClicked(view: View, item: Lessons) {

    }
}