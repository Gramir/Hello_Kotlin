open class Book(val title: String, val author: String) {

    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
        println("Current page: $currentPage")
    }
}

class eBook(title: String, author: String, val format: String = "text") : Book(title, author) {

    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
        println("Current word count: $wordCount")
    }
}

fun main() {
    val myBook = Book("1984", "George Orwell")
    myBook.readPage()

    val myEBook = eBook("Brave New World", "Aldous Huxley")
    myEBook.readPage()
}
