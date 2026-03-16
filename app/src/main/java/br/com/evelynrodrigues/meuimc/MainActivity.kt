package br.com.evelynrodrigues.meuimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.evelynrodrigues.meuimc.ui.screens.TelaInicial
import br.com.evelynrodrigues.meuimc.ui.screens.TelaInicialViewModel
import br.com.evelynrodrigues.meuimc.ui.theme.MeuIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeuIMCTheme {
                TelaInicial(viewModel = TelaInicialViewModel())
            }
        }
    }
}