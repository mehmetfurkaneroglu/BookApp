package com.eroglu.bookapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eroglu.bookapp.databinding.BookItemBinding
import com.eroglu.bookapp.model.NewBookResult

interface ItemClickedListener{
    fun onItemClicked(item: NewBookResult)
}
class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(var binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root)

    var itemClickedListener: ItemClickedListener? = null

    private val diffUtil = object : DiffUtil.ItemCallback<NewBookResult>(){
        override fun areItemsTheSame(oldItem: NewBookResult, newItem: NewBookResult) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: NewBookResult, newItem: NewBookResult) =
            oldItem == newItem
    }

    private val listDiffer = AsyncListDiffer(this,diffUtil)

    var bookList : List<NewBookResult?>
        get() = listDiffer.currentList
        set(value) = listDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.binding.bookName.text = bookList[position]?.yayin
        holder.binding.bookAuthor.text = bookList[position]?.yazar

        Glide
            .with(holder.binding.root.context)
            .load(bookList[position]?.image)
            .centerCrop()
//            .placeholder(R.drawable.loading_spinner) // Resim yüklenene kadar gösterilecek olan.
            .into(holder.binding.bookImage)

    }

    fun updateBookList(newBookList: List<NewBookResult?>) {
        listDiffer.submitList(newBookList)
    }



}