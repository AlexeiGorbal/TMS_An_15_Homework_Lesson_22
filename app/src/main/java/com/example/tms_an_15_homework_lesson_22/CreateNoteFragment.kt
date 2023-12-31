package com.example.tms_an_15_homework_lesson_22

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import com.example.tms_an_15_homework_lesson_22.databinding.FragmentCreateNoteBinding
import java.util.Date

class CreateNoteFragment : Fragment() {

    private var listener: OnNoteCreatedListener? = null
    private var _binding: FragmentCreateNoteBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? OnNoteCreatedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button.setOnClickListener {

            val title = binding.title.text.toString()
            val text = binding.text.text.toString()
            val date = Date(System.currentTimeMillis())
            val important = binding.checkBox.isChecked

            if (title.isBlank()) {
                binding.title.error = EMPTY_TITLE
            }

            if (text.isBlank()) {
                binding.text.error = EMPTY_TEXT
            }

            if (!title.isBlank() && !text.isBlank()) {
                val bundle = Bundle()
                if (important) {
                    bundle.putParcelable("important_note", ImportantNote(title, text, date))
                } else {
                    bundle.putParcelable("note", Note(title, text, date))
                }
                setFragmentResult(REQUEST_KEY, bundle)
                listener?.onNoteCreated()

                binding.title.text = null
                binding.text.text = null
                binding.checkBox.isChecked = false
            }
        }
    }

    interface OnNoteCreatedListener {
        fun onNoteCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = CreateNoteFragment()

        private const val EMPTY_TITLE = "Empty title"
        private const val EMPTY_TEXT = "Empty text"
        private const val REQUEST_KEY = "result"
    }
}