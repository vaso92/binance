package com.vasilv.binance.symbol.presentation.symbollist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.vasilv.binance.symbol.data.database.SymbolDatabase
import com.vasilv.binance.symbol.presentation.symboldetail.SymbolDetailScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

class SymbolListScreen : Screen {
    @OptIn(KoinExperimentalAPI::class)
    @Composable
    override fun Content() {
        val viewModel: SymbolListViewModel = koinViewModel<SymbolListViewModel>()
        val lifecycleOwner = androidx.compose.ui.platform.LocalLifecycleOwner.current
        val uiState by viewModel.uiState.collectAsStateWithLifecycle(lifecycleOwner)
        val navigator = LocalNavigator.currentOrThrow

        SymbolListContent(
            isLoading = uiState.isLoading,
            isRefreshing = uiState.isRefreshing,
            items = uiState.symbolList,
            onSymbolClick = { symbol ->
                navigator.push(SymbolDetailScreen(symbol))
            },
            onRefresh = viewModel::refresh,
        )
    }
}
