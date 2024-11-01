package pe.edu.idat.ec2_sm75014523

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec2_sm75014523.ui.theme.EC2_SM75014523Theme

class RegistroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EC2_SM75014523Theme {
                RegistroScreen { selectedHabilidad, selectedSignificado ->
                    // Pasar datos a ListadoActivity
                    val intent = Intent(this, ListadoActivity::class.java).apply {
                        putExtra("habilidades", selectedHabilidad)
                        putExtra("importanciaTrabajo", selectedSignificado)
                    }
                    startActivity(intent) // Llama directamente a startActivity
                }
            }
        }
    }
}

@Composable
fun RegistroScreen(onSubmit: (String, String) -> Unit) {
    var selectedHabilidad by remember { mutableStateOf("Autoconocimiento") }
    var selectedSignificado by remember { mutableStateOf("Mucho") }
    var selectedPago by remember { mutableStateOf("Bien") }
    var selectedPresion by remember { mutableStateOf("Sí") }
    var selectedCrecimiento by remember { mutableStateOf("Sí") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(text = "Cuestionario", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Pregunta sobre habilidades
        item {
            Text(text = "1. Marque sus habilidades:")
            val habilidades = listOf("Autoconocimiento", "Empatía", "Comunicación asertiva", "Toma de decisiones", "Pensamiento crítico", "Ninguno")
            habilidades.forEach { habilidad ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedHabilidad == habilidad,
                        onClick = { selectedHabilidad = habilidad }
                    )
                    Text(text = habilidad, modifier = Modifier.padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre opciones
            }
        }

        // Pregunta 2
        item {
            Text(text = "2. ¿Cuán significativo es tu trabajo?")
            val significados = listOf("Mucho", "Más o menos", "Poco")
            significados.forEach { significado ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedSignificado == significado,
                        onClick = { selectedSignificado = significado }
                    )
                    Text(text = significado, modifier = Modifier.padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre opciones
            }
        }

        // Pregunta 3
        item {
            Text(text = "3. ¿Qué tan bien te pagan en el trabajo que haces?")
            val pagos = listOf("Bien", "Regular", "Mal")
            pagos.forEach { pago ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedPago == pago,
                        onClick = { selectedPago = pago }
                    )
                    Text(text = pago, modifier = Modifier.padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre opciones
            }
        }

        // Pregunta 4
        item {
            Text(text = "4. ¿Trabajas bajo presión?")
            val presionOpciones = listOf("Sí", "No")
            presionOpciones.forEach { opcion ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedPresion == opcion,
                        onClick = { selectedPresion = opcion }
                    )
                    Text(text = opcion, modifier = Modifier.padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre opciones
            }
        }

        // Pregunta 5
        item {
            Text(text = "5. ¿Tienes oportunidad de crecimiento en tu trabajo?")
            val crecimientoOpciones = listOf("Sí", "No")
            crecimientoOpciones.forEach { opcion ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedCrecimiento == opcion,
                        onClick = { selectedCrecimiento = opcion }
                    )
                    Text(text = opcion, modifier = Modifier.padding(start = 8.dp))
                }
                Spacer(modifier = Modifier.height(8.dp)) // Espacio entre opciones
            }
        }

        // Botón Resolver
        item {
            Spacer(modifier = Modifier.height(24.dp)) // Espacio antes del botón
            Button(
                onClick = {
                    onSubmit(selectedHabilidad, selectedSignificado) // Llama a la función de callback
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Resolver")
            }
        }
    }
}
