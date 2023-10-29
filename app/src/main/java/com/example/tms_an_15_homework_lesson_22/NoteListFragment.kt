package com.example.tms_an_15_homework_lesson_22

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_an_15_homework_lesson_22.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment(R.layout.fragment_note_list) {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.recycler.layoutManager = LinearLayoutManager(context)

        val adapter = NoteAdapter {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, it.title + "\n" + it.text)
            val chooser = Intent.createChooser(intent, null)
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        }

        binding.recycler.adapter = adapter

        setFragmentResultListener("result") { requestKey, bundle ->
            val note = (bundle.getParcelable("note") as? Note)
                ?: (bundle.getParcelable("important_note") as? ImportantNote)
            if (note != null) {
                adapter.addNote(note)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = NoteListFragment()
    }
}