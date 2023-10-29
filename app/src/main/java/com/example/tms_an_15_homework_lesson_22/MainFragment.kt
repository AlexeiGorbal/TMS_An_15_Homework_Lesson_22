package com.example.tms_an_15_homework_lesson_22

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import com.example.tms_an_15_homework_lesson_22.databinding.ActivityMainBinding
import com.example.tms_an_15_homework_lesson_22.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main), CreateNoteFragment.OnNoteCreatedListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.commit {
                add(R.id.fragment_container, NoteListFragment.newInstance())
            }

            binding.button?.setOnClickListener {
                childFragmentManager.commit {
                    add(R.id.fragment_container, CreateNoteFragment.newInstance())
                    addToBackStack(null)
                }
                binding.button?.isVisible = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onNoteCreated() {

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            childFragmentManager.popBackStack()
            binding.button?.isVisible = true
        }
    }
}