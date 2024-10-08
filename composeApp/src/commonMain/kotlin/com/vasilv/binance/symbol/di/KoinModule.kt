package com.vasilv.binance.symbol.di

import com.vasilv.binance.symbol.data.repository.SymbolRepositoryImpl
import com.vasilv.binance.symbol.data.repository.remote.SymbolsRemoteDataSource
import com.vasilv.binance.symbol.domain.repository.SymbolRepository
import com.vasilv.binance.symbol.presentation.symboldetail.SymbolDetailViewModel
import com.vasilv.binance.symbol.presentation.symbollist.SymbolListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(config: KoinAppDeclaration? = null) =
    startKoin {
        config?.invoke(this)
        modules(
            provideDataSourceModule,
            provideViewModelModule,
            platformModule()
        )
    }

val provideDataSourceModule = module {
    singleOf(::SymbolRepositoryImpl).bind<SymbolRepository>()
    single<SymbolsRemoteDataSource> { SymbolsRemoteDataSource() }
}

val provideViewModelModule = module {
    viewModelOf(::SymbolListViewModel)
    viewModel { (symbolId: String) -> SymbolDetailViewModel(symbolId, get()) }
}