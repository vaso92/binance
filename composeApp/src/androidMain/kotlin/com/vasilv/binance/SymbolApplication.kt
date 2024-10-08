package com.vasilv.binance

import android.app.Application
import com.vasilv.binance.symbol.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

class SymbolApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@SymbolApplication)
        }
    }
}