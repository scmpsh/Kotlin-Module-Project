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

            val isReturn = showMenu("### Список заметок: ###", menuItems, false)
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
        val menu = mutableListOf(
            MenuItem("Содержимое заметки") {
                println("Содержимое заметки: ${note.content}")
            }
        )
        while (true) {
            val isReturn = showMenu("Заметка: ${note.title}", menu, false)
            if (isReturn) break
        }
    }
}
