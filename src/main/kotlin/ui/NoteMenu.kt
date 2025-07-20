package ui

import InputUtils
import model.Archive
import model.MenuItem
import model.Note

class NoteMenu {

    fun showNotes(archive: Archive) {
        while (true) {
            println("\n### Архив: ${archive.title} ###")
            val menuItems = mutableListOf<MenuItem>().apply {
                add(MenuItem("Создать заметку:") { createNote(archive) })
                addAll(archive.notes.map {
                    MenuItem(it.title) { showNote(it) }
                })
            }

            val isReturn = Menu.showMenu("### Список заметок: ###", menuItems, false)
            if (isReturn) break
        }
    }

    fun createNote(archive: Archive) {
        val title = InputUtils.readNonEmptyLine("Введите заголовок заметки: ")
        val content = InputUtils.readNonEmptyLine("Введите содержимое заметки: ")
        archive.notes.add(Note(title, content))
        println("### Заметка \"$title\" добавлена ###")
    }

    fun showNote(note: Note) {
        while (true) {
            val isReturn = Menu.showMenu(
                "Заметка: ${note.title}",
                mutableListOf(
                    MenuItem("Содержимое заметки") {
                        println("Содержимое заметки: ${note.content}")
                    }
                ),
                false
            )
            if (isReturn) break
        }
    }
}
