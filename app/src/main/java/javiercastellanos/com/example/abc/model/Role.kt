package javiercastellanos.com.example.abc.model

import javiercastellanos.com.example.abc.ui.utils.SelectableOption

data class Role(
    override val id: Int,
    val rol: String
) : SelectableOption {
    override val descripcion: String
        get() = rol
}