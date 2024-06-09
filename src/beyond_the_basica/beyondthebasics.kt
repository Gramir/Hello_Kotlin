package beyond_the_basica
import kotlin.random.Random


class Book(private val title: String, private val author: String, private val year: Int) {
    fun getTitleAndAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    fun getTitleAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

const val MAX_BOOKS_BORROWED = 5

class Book1(val title: String, val author: String, val year: Int, private val borrowedBooks: Int) {
    var pages: Int = 0

    fun canBorrow(): Boolean {
        return borrowedBooks < MAX_BOOKS_BORROWED
    }

    fun printUrl() {
        println("${Constants.BASE_URL}${title.replace(" ", "%20")}.html")
    }

    companion object {
        const val BASE_URL = "https://www.librarycatalog.com/books/"
    }
}

object Constants {
    const val BASE_URL = Book1.BASE_URL
}

fun Book1.weight(): Double {
    return pages * 1.5
}

fun Book1.tornPages(torn: Int) {
    pages = (pages - torn).coerceAtLeast(0)
}

class Puppy {
    fun playWithBook(book: Book1) {
        val torn = Random.nextInt(1, 10)
        println("Puppy tears $torn pages!")
        book.tornPages(torn)
    }
}



fun main() {
    val book = Book("1984", "George Orwell", 1949)
    val titleAndAuthor = book.getTitleAndAuthor()
    println("Title: ${titleAndAuthor.first}, Author: ${titleAndAuthor.second}")

    val titleAuthorAndYear = book.getTitleAuthorAndYear()
    println("Title: ${titleAuthorAndYear.first}, Author: ${titleAuthorAndYear.second}, Year: ${titleAuthorAndYear.third}")

    println("Here is your book \"${titleAuthorAndYear.first}\" written by ${titleAuthorAndYear.second} in ${titleAuthorAndYear.third}.")

    val allBooks = setOf("Hamlet", "Macbeth", "Othello", "King Lear", "The Tempest")
    val library = mapOf("William Shakespeare" to allBooks)
    val containsHamlet = library.any { it.value.contains("Hamlet") }
    println("Library contains 'Hamlet': $containsHamlet")

    val moreBooks = mutableMapOf("J.K. Rowling" to "Harry Potter and the Philosopher's Stone")
    val bookTitle = "Harry Potter and the Chamber of Secrets"
    moreBooks.getOrPut("J.K. Rowling") { bookTitle }
    println(moreBooks)
    val book1 = Book1("1984", "George Orwell", 1949, 3)
    println("Can borrow more books: ${book1.canBorrow()}")
    book1.printUrl()
    val book2 = Book1("1984", "George Orwell", 1949, 3).apply { pages = 100 }
    val puppy = Puppy()

    println("Initial pages: ${book1.pages}")
    while (book1.pages > 0) {
        puppy.playWithBook(book1)
        println("Remaining pages: ${book1.pages}")
    }

    println("Book has no more pages left!")
}

