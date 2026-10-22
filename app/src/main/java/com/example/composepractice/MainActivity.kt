package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    BookList(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Composable ПРИМЕР LazyColumn
//fun NameList(modifier: Modifier = Modifier) {
//    val elements = (1..100).map { "Элемент $it" }
//    LazyColumn(modifier = modifier)
//    {
//        items(elements) { element ->
//            Text(text = element, modifier = Modifier.padding(16.dp))
//        }
//    }
//}

data class Book(val title: String, val author: String)

@Composable
fun BookItem(book: Book)
{
    Column(modifier = Modifier.padding(16.dp)){
        Text("${book.author} - ${book.title}", fontWeight = FontWeight.Bold, fontSize = 18.sp)

    }
}

@Composable
fun BookList(modifier: Modifier = Modifier) {
    val books = remember {
        mutableStateListOf(
            Book("Мастер и Маргарита", "Михаил Булгаков"),
            Book("Гордость и предубеждение", "Джейн Остин"),
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = { books.add(Book("Новая книга ${books.size + 1}", "Автор")) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        {
            Text("Добавить")
        }
        Button(
            onClick = { books.removeLastOrNull() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        {
            Text("Удалить")
        }


        LazyColumn {
            items(books) { book -> BookItem(book) }
        }
    }
}
