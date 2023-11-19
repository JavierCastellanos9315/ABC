package javiercastellanos.com.example.abc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import dagger.hilt.android.AndroidEntryPoint
import javiercastellanos.com.example.abc.ui.academic_data.AcademicDataAddScreen
import javiercastellanos.com.example.abc.ui.academic_data.AcademicDataScreen
import javiercastellanos.com.example.abc.ui.expierience.LaboralExperienceAddScreen
import javiercastellanos.com.example.abc.ui.expierience.LaboralExperienceScreen
import javiercastellanos.com.example.abc.ui.interview.InterviewScreen
import javiercastellanos.com.example.abc.ui.login.LoginScreen
import javiercastellanos.com.example.abc.ui.main_menu.MainMenuAdminScreen
import javiercastellanos.com.example.abc.ui.main_menu.MainMenuCompanyScreen
import javiercastellanos.com.example.abc.ui.main_menu.MainScreen
import javiercastellanos.com.example.abc.ui.new_contract.NewContractScreen
import javiercastellanos.com.example.abc.ui.perfomance_evaluation.NewPerformanceEvaluationScreen
import javiercastellanos.com.example.abc.ui.perfomance_evaluation.PerfEvalApplicantDetailScreen
import javiercastellanos.com.example.abc.ui.perfomance_evaluation.PerfEvalApplicantScreen
import javiercastellanos.com.example.abc.ui.personal_data.PersonalDataScreen
import javiercastellanos.com.example.abc.ui.profile.ProfileScreen
import javiercastellanos.com.example.abc.ui.sign_up.SignUpScreen
import javiercastellanos.com.example.abc.ui.tecnic_test.DoingTechnicTestScreen
import javiercastellanos.com.example.abc.ui.tecnic_test.TechnicTestScreen
import javiercastellanos.com.example.abc.ui.theme.ABCTheme
import javiercastellanos.com.example.abc.ui.welcome.WelcomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ABCTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("about") {

                    }
                    navigation(
                        startDestination = "WelcomeScreen",
                        route = "welcome"
                    ) {
                        composable("WelcomeScreen") {
                            WelcomeScreen(navController = navController)
                        }
                        composable(route = "loginScreen") {
                            LoginScreen(navController = navController)
                        }
                        composable("SignUpScreen") {
                            SignUpScreen(navController = navController)

                        }
                    }
                    navigation(
                        startDestination = "MainScreen",
                        route = "mainScreenNavigation"
                    ) {
                        composable("MainScreen") {
                            MainScreen(navController = navController)
                        }
                        composable("ProfileScreen") {
                            ProfileScreen(navController = navController)
                        }
                        composable("PersonalDataScreen") {
                            PersonalDataScreen(navController = navController)
                        }
                        composable("AcademicDataScreen") {
                            AcademicDataScreen(navController = navController)
                        }
                        composable("AcademicDataAddScreen") {
                            AcademicDataAddScreen(navController = navController)
                        }
                        composable("LaboralExperienceScreen") {
                            LaboralExperienceScreen(navController = navController)
                        }
                        composable("AddLaboralExperienceScreen") {
                            LaboralExperienceAddScreen(navController = navController)
                        }
                        composable("TechnicTestScreen") {
                            TechnicTestScreen(navController = navController)
                        }
                        composable("DoingTestScreen/{id}",
                            arguments = listOf(
                                navArgument("id") {
                                    type = NavType.IntType
                                    defaultValue = 0
                                }
                            )) {
                            val id = it.arguments?.getInt("id") ?: 0
                            DoingTechnicTestScreen(id, navController = navController)
                        }
                        composable("PerfEvalApplicantScreen") {
                            PerfEvalApplicantScreen(navController = navController)
                        }
                        composable("PerfEvalApplicantDetailScreen/{description}/{company}/{date}",
                            arguments = listOf(
                                navArgument("description") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument("company") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                },
                                navArgument("date") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )) {
                            val description = it.arguments?.getString("description") ?: ""
                            val company = it.arguments?.getString("company") ?: ""
                            val date = it.arguments?.getString("date") ?: ""
                            PerfEvalApplicantDetailScreen(description, company, date, navController)
                        }
                        composable("InterviewScreenCandidate") {
                            InterviewScreen(navController = navController)
                        }
                    }
                    navigation(
                        startDestination = "MainCompanyScreen",
                        route = "mainCompanyNavigation"
                    ) {
                        composable("MainCompanyScreen") {
                            MainMenuCompanyScreen(navController = navController)
                        }
                        composable("NewPerformanceEvaluationScreen") {
                            NewPerformanceEvaluationScreen(navController = navController)
                        }
                        composable("InterviewScreenCompany") {
                            InterviewScreen(navController = navController)
                        }
                    }
                    navigation(
                        startDestination = "MainAdminScreen",
                        route = "mainAdminNavigation"
                    ) {
                        composable("MainAdminScreen") {
                            MainMenuAdminScreen(navController = navController)
                        }
                        composable("NewContractScreen") {
                            NewContractScreen(navController = navController)
                        }
                        composable("InterviewScreen") {
                            InterviewScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}
