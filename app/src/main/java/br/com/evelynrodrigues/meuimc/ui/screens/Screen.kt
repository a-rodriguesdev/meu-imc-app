package br.com.evelynrodrigues.meuimc.ui.screens

sealed class Screen {
    object FormularioPesagem : Screen()
    object ListaPesagens : Screen()
}
