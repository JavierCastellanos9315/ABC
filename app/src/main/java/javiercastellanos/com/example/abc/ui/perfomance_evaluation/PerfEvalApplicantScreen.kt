package javiercastellanos.com.example.abc.ui.perfomance_evaluation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import javiercastellanos.com.example.abc.R
import javiercastellanos.com.example.abc.model.ExperienciaOut
import javiercastellanos.com.example.abc.ui.utils.SharePreference

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PerfEvalApplicantScreen(
    navController: NavController,
    viewModel: PerformanEvaluationViewModel = hiltViewModel()
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.borderText),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        MainContent(innerPadding, viewModel, keyboardController)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MainContent(
    padding: PaddingValues, performanceEvaluationViewModel: PerformanEvaluationViewModel,
    keyboardController: SoftwareKeyboardController?
) {
    val listPerformanceEvaluations: List<ExperienciaOut>? by performanceEvaluationViewModel.listPerformanceEvaluations!!.observeAsState(
        initial = listOf()
    )
    val sharePreference = SharePreference(LocalContext.current)
    performanceEvaluationViewModel.getInfoCandidate(sharePreference)
    LazyColumn(
        modifier = Modifier.padding(
            top = 96.dp,
            start = 30.dp,
            end = 30.dp,
            bottom = padding.calculateBottomPadding()
        )
    )
    {
        item {
            Text(
                text = stringResource(id = R.string.performance_evaluation),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        }
        item {
            Spacer(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(200.dp)
            )
            Spacer(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(bottom = 1.dp)
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .width(200.dp)
            )
        }
        if (listPerformanceEvaluations?.isNotEmpty() == true) {
            listPerformanceEvaluations!!.forEach {
                item {
                    itemPerfomanceEvalData(
                        companyName = it.Rol.rol,
                        stateEval = it.nombre_empresa,
                        endDate = it.fecha_fin
                    )
                }
            }
        } else {
            item {
                Text(
                    text = stringResource(id = R.string.no_experience),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                )
            }
        }


    }
}

@Composable
fun itemPerfomanceEvalData(companyName: String?, stateEval: String?, endDate: String?) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Column {
            ConstraintLayout(
                modifier = Modifier
                    .height(100.dp)
                    .weight(3f)
            ) {
                val (name, state, date) = createRefs()
                Text(text = companyName!!, modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(parent.top, margin = 2.dp)
                        start.linkTo(parent.start, margin = 20.dp)
                    }
                    .fillMaxWidth(1f), fontWeight = FontWeight.Bold)
                Row(modifier = Modifier
                    .constrainAs(state) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start, margin = 20.dp)
                    }
                    .fillMaxWidth(1f)) {
                    Text(text = stateEval!!, modifier = Modifier.fillMaxWidth())
                }
                Row(modifier = Modifier
                    .constrainAs(date) {
                        bottom.linkTo(parent.bottom, margin = 2.dp)
                        start.linkTo(parent.start, margin = 20.dp)
                    }
                    .fillMaxWidth(1f)) {
                    Text(text = endDate!!, modifier = Modifier.fillMaxWidth())
                }
            }
            Spacer(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(200.dp)
            )
            Spacer(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(bottom = 1.dp)
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .width(200.dp)
            )
        }
    }
}