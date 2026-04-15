package com.kiuza1004.programlist1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiuza1004.programlist1.domain.model.DevLog
import com.kiuza1004.programlist1.domain.repository.DevLogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DevLogViewModel @Inject constructor(
    private val repository: DevLogRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow<String?>(null)
    val selectedCategory = _selectedCategory.asStateFlow()

    val devLogs: StateFlow<List<DevLog>> = combine(
        repository.getAllLogs(),
        searchQuery,
        selectedCategory
    ) { logs, query, category ->
        logs.filter { log ->
            val matchesQuery = log.title.contains(query, ignoreCase = true) || 
                               log.content.contains(query, ignoreCase = true)
            val matchesCategory = category == null || log.category == category
            matchesQuery && matchesCategory
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    fun onCategoryChange(category: String?) {
        _selectedCategory.value = category
    }

    fun saveLog(log: DevLog) {
        viewModelScope.launch {
            if (log.id == 0L) {
                repository.insertLog(log)
            } else {
                repository.updateLog(log)
            }
        }
    }

    fun deleteLog(log: DevLog) {
        viewModelScope.launch {
            repository.deleteLog(log)
        }
    }
}
