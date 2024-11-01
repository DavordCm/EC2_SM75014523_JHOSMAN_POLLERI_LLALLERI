package pe.edu.idat.ec2_sm75014523

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.idat.ec2_sm75014523.ui.theme.EC2_SM75014523Theme
import androidx.compose.ui.platform.LocalContext // Importar LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EC2_SM75014523Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current // Obtener el contexto
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen de logo
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Asegúrate de que el drawable exista
            contentDescription = "Logo de la App",
            modifier = Modifier.size(100.dp) // Tamaño del logo
        )

        Spacer(modifier = Modifier.height(24.dp)) // Espacio entre el logo y los botones

        // Botón de Registro
        Button(onClick = {
            // Navegar a RegistroActivity
            val intent = Intent(context, RegistroActivity::class.java)
            context.startActivity(intent) // Usar el contexto
        }) {
            Text(text = "REGISTRO")
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre botones

        // Botón de Listado
        Button(onClick = {
            // Navegar a ListadoActivity
            val intent = Intent(context, ListadoActivity::class.java)
            context.startActivity(intent) // Usar el contexto
        }) {
            Text(text = "LISTADO")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
