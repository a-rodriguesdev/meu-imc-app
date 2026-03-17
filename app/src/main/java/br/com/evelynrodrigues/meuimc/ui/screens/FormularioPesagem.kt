package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.evelynrodrigues.meuimc.model.Pesagem
import br.com.evelynrodrigues.meuimc.ui.theme.MeuIMCTheme
import br.com.evelynrodrigues.meuimc.utils.ImcHelper
import java.time.LocalDate

@Composable
fun FormularioPesagem(
    onCancelar : () -> Unit,
    onRegistrarPeso : (pesagem: Pesagem) -> Unit
) {
    var dataPesagem by remember {
        mutableStateOf(LocalDate.now().toString())
    }

    var altura by remember {
        mutableStateOf("")
    }

    var peso by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
            .background(color = Color.LightGray)
            .safeContentPadding()
    ) {
        Text(
            text = "Nova pesagem",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Informe seus dados",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = dataPesagem,
            onValueChange = { dataPesagem = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Data da pesagem")
            },
            readOnly = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = altura,
            onValueChange = { altura = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Altura")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = peso,
            onValueChange = { peso = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Peso")
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button (
            onClick = {
                val imc = ImcHelper
                    .calcularImc(
                        peso.toDouble(),
                        altura.toDouble()
                    )
                val classificacao = ImcHelper
                    .obterClassificacao(
                        imc
                    ).keys.first()
                val cor = ImcHelper
                    .obterClassificacao(
                        imc
                    ).values.first()
                val pesagem = Pesagem(
                    id = 0,
                    data = dataPesagem,
                    altura = altura.toDouble(),
                    peso = peso.toDouble(),
                    imc = imc,
                    classificacao = classificacao,
                    cor = cor
                )
                onRegistrarPeso(pesagem)
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Registrar peso")
        }
        Spacer(modifier = Modifier.height(48.dp))
        TextButton(
            onClick = { onCancelar() },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Cancelar e Voltar")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun FormularioPesagemPreview() {
    MeuIMCTheme {
        FormularioPesagem(
            onCancelar = {},
            onRegistrarPeso = {}
        )
    }
}