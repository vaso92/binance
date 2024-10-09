package com.vasilv.binance.symbol.presentation.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun displayError(errorMessage: String?, onMessageShown: () -> Unit) {
    val context = LocalContext.current

    LaunchedEffect(errorMessage) {
        errorMessage?.let {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            onMessageShown()
        }
    }
}