import java.util.Scanner

object InputUtils {
    private val scanner = Scanner(System.`in`)

    fun readNonEmptyLine(command: String): String {
        while (true) {
            println(command)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) return input
            println("Нельзя задавать пустые значения. Попробуйте снова")
        }
    }

    fun readMenuOption(): Int {
        while (true) {
            val number = scanner.nextLine().toIntOrNull()
            if (number != null) return number
            println("Вы ввели неверное значние. Введите номер пункта меню")
        }
    }
}