package javiercastellanos.com.example.abc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import javiercastellanos.com.example.abc.ui.academic_data.AcademicDataScreen
import javiercastellanos.com.example.abc.ui.personal_data.PersonalDataScreen
import javiercastellanos.com.example.abc.ui.sign_up.SignUpScreen
import javiercastellanos.com.example.abc.ui.skills.SkillsScreen
import javiercastellanos.com.example.abc.ui.theme.ABCTheme
import javiercastellanos.com.example.abc.ui.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeScreen()
            /*ABCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }*/
        }
    }
}
