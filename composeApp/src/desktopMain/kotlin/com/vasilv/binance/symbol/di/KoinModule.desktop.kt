package com.vasilv.binance.symbol.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.vasilv.binance.symbol.data.database.SymbolDatabase
import com.vasilv.binance.symbol.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<SymbolDatabase> { getDatabaseBuilder().setDriver(BundledSQLiteDriver()).build() }
}