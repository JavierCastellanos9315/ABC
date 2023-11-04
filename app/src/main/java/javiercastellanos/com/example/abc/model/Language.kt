package javiercastellanos.com.example.abc.model

import javiercastellanos.com.example.abc.ui.utils.SelectableOption

data class Language(
    override val id: Int,
    val idioma: String
): SelectableOption {
    override val descripcion: String
        get() = idioma
}