import java.util.Scanner

class ArchiveMenu(private val name: String, scanner: Scanner) : MenuAndCreate(scanner) {
    override val menu: MutableList<Pair<String, () -> Unit>> = mutableListOf(Pair("Создать заметку") { createNode() })
    override val listName: String
        get() = "Список заметок в архиве '$name': "
}