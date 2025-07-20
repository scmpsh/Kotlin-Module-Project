package model

data class MenuItem(
    val title: String,
    val action: () -> Unit
)