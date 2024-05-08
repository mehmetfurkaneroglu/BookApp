package com.eroglu.bookapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.eroglu.bookapp.databinding.FragmentBookBinding
import com.eroglu.bookapp.viewmodel.NewBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookFragment : Fragment() {

    private val viewModel: NewBookViewModel by viewModels()

    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this

        observeLiveData()

    }

    fun observeLiveData() {
        viewModel.books.observe(viewLifecycleOwner, Observer { book ->
            book?.let {
                binding.bookListRecyclerView.visibility = View.VISIBLE
//                newBookAdapter.updateBookList(book)
            }
        })
        viewModel.booksError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    binding.bookError.visibility = View.VISIBLE
                } else {
                    binding.bookError.visibility = View.GONE
                }
            }
        })
        viewModel.booksLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    binding.bookLoading.visibility = View.VISIBLE
                    binding.bookListRecyclerView.visibility = View.GONE
                    binding.bookError.visibility = View.GONE
                } else {
                    binding.bookLoading.visibility = View.GONE
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}