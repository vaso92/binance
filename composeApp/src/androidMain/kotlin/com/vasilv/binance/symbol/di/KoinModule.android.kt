package com.vasilv.binance.symbol.di

import com.vasilv.binance.symbol.data.database.SymbolDatabase
import com.vasilv.binance.symbol.data.database.getDatabaseBuilder
import org.koin.dsl.module

actual fun platformModule() = module {
    single<SymbolDatabase> { getDatabaseBuilder(get()).build() }
}