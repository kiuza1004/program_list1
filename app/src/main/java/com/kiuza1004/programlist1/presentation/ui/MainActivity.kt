package com.kiuza1004.programlist1.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import com.kiuza1004.programlist1.presentation.ui.theme.ProgramList1Theme
import com.kiuza1004.programlist1.presentation.viewmodel.DevLogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: DevLogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgramList1Theme {
                Surface {
                    LogListScreen(viewModel = viewModel)
                }
            }
        }
    }
}
