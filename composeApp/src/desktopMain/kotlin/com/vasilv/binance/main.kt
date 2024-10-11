package com.vasilv.binance

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vasilv.binance.symbol.di.initKoin
import com.vasilv.binance.symbol.presentation.App

fun main() = application {
    initKoin {
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "KotlinProject",
    ) {
        App()
    }
}