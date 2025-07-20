package ui

import InputUtils
import model.MenuItem

fun showMenu(title: String, menuItems: MutableList<MenuItem>, isRoot: Boolean): Boolean {
    menuItems.add(MenuItem("Выход") { })

    println(title)
    menuItems.forEachIndexed { index, menuItem ->
        println("$index. ${menuItem.title}")
    }

    println("### Введите номер команды: ###")
    val option = InputUtils.readMenuOption()

    if (option !in menuItems.indices) {
        println("Вы выбрали команду, которой нет. Повторите попытку!")
    }

    if (option == menuItems.lastIndex) {
        return if (isRoot) {
            println("Выход из программы")
            kotlin.system.exitProcess(0)
        } else {
            println("Возврат в предыдущее меню")
            true
        }
    }
    menuItems[option].action()
    return false
}

