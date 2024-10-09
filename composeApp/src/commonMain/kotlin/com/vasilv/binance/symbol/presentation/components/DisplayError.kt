package com.vasilv.binance.symbol.presentation.components

import androidx.compose.runtime.Composable

@Composable
expect fun displayError(errorMessage: String?, onMessageShown: () -> Unit)