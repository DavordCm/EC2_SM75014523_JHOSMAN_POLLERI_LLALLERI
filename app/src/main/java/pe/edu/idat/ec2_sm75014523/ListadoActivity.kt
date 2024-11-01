package pe.edu.idat.ec2_sm75014523

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec2_sm75014523.ui.theme.EC2_SM75014523Theme

class ListadoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recibir datos pasados desde RegistroActivity
        val habilidades = intent.getStringExtra("habilidades") ?: "No se registraron habilidades"
        val importanciaTrabajo = intent.getStringExtra("importanciaTrabajo") ?: "No se registró la importancia del trabajo"

        setContent {
            EC2_SM75014523Theme {
                ListadoScreen(habilidades, importanciaTrabajo)
            }
        }
    }
}

@Composable
fun ListadoScreen(habilidades: String, importanciaTrabajo: String) {
    // Lista de eventos internacionales
    val eventosInternacionales = listOf(
        "Copa Mundial de la FIFA",
        "Juegos Olímpicos",
        "Conferencia de las Partes (COP)",
        "Día de la Tierra",
        "Festival de Cannes",
        "Olimpiadas Especiales",
        "Día Internacional de la Mujer",
        "Cumbre del Clima",
        "Feria del Libro de Frankfurt",
        "Día Mundial de la Salud",
        "Cumbre del G20",
        "Copa América"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Listado de Resultados", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Habilidades: $habilidades")
        Text(text = "Importancia del trabajo: $importanciaTrabajo")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Eventos Internacionales:", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        // Mostrar lista de eventos
        eventosInternacionales.forEach { evento ->
            Text(text = evento, modifier = Modifier.padding(8.dp))
        }
    }
}
