package com.example.bookshelfapp

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookshelfapp.databinding.ItemBookBinding

class BooksAdapter(private var books: List<Book>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {


    var onBookClickListener: ((Book) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

    inner class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.bookTitle.text = book.title
            Glide.with(binding.root.context)
                .load(book.thumbnail)
                .into(binding.bookImage)


            binding.root.setOnClickListener {
                onBookClickListener?.invoke(book)
            }
        }
    }

    // Method to update the list of books
    fun updateBooks(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }
}