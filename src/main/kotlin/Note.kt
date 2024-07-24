import java.util.Scanner

class Note(private val name: String, private val content: MutableList<String>, scanner: Scanner) : Menu(scanner) {

    override val menu: MutableList<Pair<String, () -> Unit>> = mutableListOf(
            Pair("Добавить содержимое") { addContent() },
            Pair("Просмотреть содержимое") { printContent() }
    )
    override val listName: String = "Список действий: "

    private val addContent: () -> Unit = {
        while (true) {
            println("\nВведите, что хотите добавить:")
            val extra = scanner.nextLine()
            if (extra.isNotEmpty()) {
                content.add(extra)
                println("Добавлено успешно!")
                break
            } else println("Добавочные данные не могут быть пустыми, попробуйте снова")
        }
    }

    private val printContent: () -> Unit = {
        println("\nСодержимое заметки '${name}': ")
        for (text in content) println(text)
    }
}