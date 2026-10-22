package com.example.composepractice

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class BookViewModel : ViewModel() {
    private val _books = mutableStateListOf(
        Book("Мастер и Маргарита", "Михаил Булгаков"),
        Book("Гордость и предубеждение", "Джейн Остин")
    )
    val books: List<Book> = _books

    fun addBook() {
        _books.add(Book("Новая книга ${_books.size + 1}", "Автор"))
    }

    fun removeLastBook() {
        _books.removeLastOrNull()
    }
}