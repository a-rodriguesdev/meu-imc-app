package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.evelynrodrigues.meuimc.ui.theme.MeuIMCTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(viewModel: TelaInicialViewModel) {

    val telaAtual = viewModel.telaAtual.value

    Scaffold(
        modifier = Modifier
            .background(color = Color.LightGray),
        topBar = {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            text = "Meu IMC",
                        )
                        Text(
                            text = "Dashboard",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        },
        floatingActionButton = {
            if (telaAtual is Screen.ListaPesagens){
                FloatingActionButton(
                    onClick = {
                        viewModel.abrirFormularioPesagem()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Nova pesagem"
                    )
                }
            }

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                when (telaAtual){
                    is Screen.FormularioPesagem -> FormularioPesagem(
                        onCancelar = {
                            viewModel.abrirListaPesagens()
                        })
                    is Screen.ListaPesagens -> ListaPesagens()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaInicialPreview() {
    MeuIMCTheme() {
        TelaInicial(viewModel = TelaInicialViewModel())
    }
}