package zelimkhan.magomadov.utilitybillestimator.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import zelimkhan.magomadov.utilitybillestimator.presentation.service.ServiceScreen
import zelimkhan.magomadov.utilitybillestimator.presentation.service.ServiceViewModel
import zelimkhan.magomadov.utilitybillestimator.presentation.ui.theme.UtilityBillEstimatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtilityBillEstimatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: ServiceViewModel by viewModels()
                    val mainState by viewModel.serviceState.collectAsState()
                    val paymentState by viewModel.billPaymentState.collectAsState()

                    ServiceScreen(
                        mainState = mainState,
                        paymentState = paymentState,
                        onIntent = viewModel::onIntent
                    )
                }
            }
        }
    }
}