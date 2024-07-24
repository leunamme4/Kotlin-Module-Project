import java.util.Scanner

class MainMenu(scanner: Scanner) : MenuAndCreate(scanner) {
    override val listName: String
        get() = "Список архивов: "

    override val menu: MutableList<Pair<String, () -> Unit>> = mutableListOf(Pair("Создать архив") { createNode() })
}