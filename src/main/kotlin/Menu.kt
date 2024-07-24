import java.util.Scanner

abstract class Menu(private val scanner: Scanner) {
    abstract val menu: MutableList<Pair<String, () -> Unit>>
    abstract val listName: String
    private fun printMenu() {
        println()
        println(listName)
        for (i in menu.indices) {
            println("${i}. ${menu[i].first}")
        }
        println("${menu.size}. Выход")
    }

    val chooseNext: () -> Unit = {
        while (true) {
            printMenu()
            println("Выберите действие: ")
            if (scanner.hasNextInt()) {
                val input = scanner.nextInt()
                scanner.nextLine()
                when (input) {
                    in 0 until menu.size -> menu[input].second()
                    menu.size -> break
                    else -> println("Такого пункта в меню нет. Пожалуйста, выберите пункт меню.")
                }
            } else {
                println("Неверный формат ввода. Пожалуйста, введите число в соответствии с выбранным пунктом меню.")
                scanner.nextLine()
            }
        }
    }
}