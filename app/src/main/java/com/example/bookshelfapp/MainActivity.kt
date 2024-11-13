package com.example.bookshelfapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookshelfapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BooksViewModel by viewModels {
        ViewModelProviderFactory(BooksRepository(BooksApiService.create()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BooksAdapter(emptyList())
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter

        adapter.onBookClickListener = { book ->
            val url = book.infoLink
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        viewModel.searchBooks("Kotlin").observe(this, { books ->
            adapter.updateBooks(books)
        })
    }
}