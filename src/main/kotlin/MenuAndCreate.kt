import java.util.Scanner

abstract class MenuAndCreate(scanner: Scanner) : Menu(scanner) {
    val createNode: () -> Unit = {
        while (true) {
            println("\nВведите название: ")
            val name = scanner.nextLine()
            println()
            if (name.trim().isNotEmpty()) {
                if (this is MainMenu) {
                    val archive = ArchiveMenu(name, scanner)
                    menu.add(Pair(name) { archive.chooseNext() })
                    println("Архив создан успешно!")
                    break
                } else {
                    while (true) {
                        println("Введите содержание заметки: ")
                        val content = scanner.nextLine()
                        if (content.trim().isNotEmpty()) {
                            val note = Note(name, mutableListOf(content), scanner)
                            menu.add(Pair(name, note.chooseNext))
                            println("Заметка создана успешно!")
                            break
                        } else {
                            println("Содержание не может быть пустым.")
                        }
                    }
                    break
                }
            } else println("Название не может быть пустым.")
        }
    }
}