package javiercastellanos.com.example.abc.model

import javiercastellanos.com.example.abc.ui.utils.SelectableOption

data class Country(
    override val id: Int,
    val pais: String
):SelectableOption {
    override val descripcion: String
        get() = pais
}