import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import utdi.zaki.nedhiansyah.gambar.ui.theme.GambarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GambarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Content of your app
                    MyImageUI()
                }
            }
        }
    }
}

@Composable
fun MyImageUI() {
    var pageIndex by remember { mutableStateOf(0) }
    val imageResources = listOf(
        utdi.zaki.nedhiansyah.gambar.R.drawable.chelsea,
        // Add more image resources as needed
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "CHELSEA FC",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Image
        Image(
            painter = painterResource(id = imageResources[pageIndex]),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(MaterialTheme.shapes.medium)
                .align(Alignment.CenterHorizontally)
        )

        // Deskripsi
        Text(
            text = "Chelsea didirikan pada tanggal 10 Maret 1905 di sebuah pub The Rising Sun (kini restoran The Butcher's Hook) dan pertama kali bermain pada kompetisi Football League. John Robertson seorang pemain timnas Skotlandia berusia 28 tahun saat itu dipilih merangkap jabatan pemain-manajer pertama Chelsea.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Membuat button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { pageIndex = maxOf(0, pageIndex - 1) }) {
                Text("Previous")
            }
            Button(onClick = { pageIndex = minOf(imageResources.size - 1, pageIndex + 1) }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyImageUI() {
    GambarTheme {
        MyImageUI()
    }
}
