package ui

import InputUtils
import model.Archive
import model.MenuItem

class ArchiveMenu {

    private val archives: MutableList<Archive> = mutableListOf()

    fun showArchive() {
        while (true) {
            val menuItems = mutableListOf<MenuItem>().apply {
                add(MenuItem("Создать архив") { createArchive() })
                addAll(archives.map { archive ->
                    MenuItem(archive.title) { NoteMenu().showNotes(archive) }
                }.toList())
            }

            Menu.showMenu("\n### Список архивов: ###", menuItems, true)
        }
    }

    fun createArchive() {
        val title = InputUtils.readNonEmptyLine("Введите название архива:")
        archives.add(Archive(title, mutableListOf()))
        println("Архив \"$title\" создан")
    }
}