package com.kiuza1004.programlist1.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kiuza1004.programlist1.domain.model.DevLog
import com.kiuza1004.programlist1.presentation.viewmodel.DevLogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogEditorScreen(
    viewModel: DevLogViewModel,
    logId: Long?,
    onBack: () -> Unit
) {
    // In a real navigation setup, we would load the log by ID. 
    // For this boilerplate, we'll use a local state for simplicity.
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("General") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (logId == null) "New Log" else "Edit Log") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.saveLog(
                            DevLog(
                                id = logId ?: 0,
                                title = title,
                                content = content,
                                category = category,
                                status = "In Progress", // Default status
                                createdAt = System.currentTimeMillis(),
                                updatedAt = System.currentTimeMillis()
                            )
                        )
                        onBack()
                    }) {
                        Icon(Icons.Default.Check, contentDescription = "Save")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )
            // Multi-line editor for dev log content
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content (Markdown supported)") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                minLines = 10
            )
        }
    }
}
