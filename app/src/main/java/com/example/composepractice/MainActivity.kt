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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
                    //NameList(modifier = Modifier.padding(innerPadding))
                    //Books(modifier = Modifier.padding(innerPadding))
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

@Composable
fun NameList(modifier: Modifier = Modifier)
{
    val elements = (1..100).map {"Элемент $it"}
    LazyColumn(modifier = modifier)
    {
        items(elements) {
            element -> Text(text = element, modifier = Modifier.padding(16.dp))
        }
    }
}

data class Book(val title: String, val author: String)

@Composable
fun BookItem(book: Book)
{
    Column(modifier = Modifier.padding(16.dp)){
        Text("${book.author} - ${book.title}", fontWeight = FontWeight.Bold, fontSize = 18.sp)

    }
}

@Composable
fun BookList(modifier: Modifier = Modifier)
{
    val books = remember{mutableListOf(
        Book("Мастер и Маргарита", "Михаил Булгаков"),
        Book("Гордость и предубеждение", "Джейн Остин"),
    )
    }
  
    LazyColumn(modifier = modifier) {
        items(books) { book -> BookItem(book) }
    }
}



//fun Books(modifier: Modifier = Modifier)
//{
//
//
//    val book1 = Book("Мастер и Маргарита", "Булгаков")
//    val book2 = Book("Гордость и предубеждение", "Джейн Остин")
//    val book3 = Book("Граф Монте-Кристо", "Александр Дюма")
//    val book4 = Book("Сто лет одиночества", "Габриэль Гарсиа Маркес")
//    val book5 = Book("Бойцовский Клуб", "Чак Паланик")
//
//    val listBook = listOf(book1,book2,book3,book4,book5)
//
//    Column {
//        listBook.forEach { book -> Text(text = "${book.title} - ${book.author}") }
//
//    }
//
//    LazyColumn(modifier = modifier){
//        items(listBook)
//        {
//            books -> Text(text = "${books.title} - ${books.author}")
//        }
//    }
//}


