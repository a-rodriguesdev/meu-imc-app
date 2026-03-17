package br.com.evelynrodrigues.meuimc.utils

object ImcHelper {
    fun calcularImc(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }

    fun obterClassificacao(imc: Double): Map<String, String> {
        return when {
            imc < 18.5 -> mapOf("Abaixo do peso" to "FFF54927")
            imc < 25.0 -> mapOf("Peso normal" to "FF62A172")
            imc < 30.0 -> mapOf("Acima do peso" to "FFED8618")
            else -> mapOf("Obesidade" to "FFF54927")
        }
    }
}