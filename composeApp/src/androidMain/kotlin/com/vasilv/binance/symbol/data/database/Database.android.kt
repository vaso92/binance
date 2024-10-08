package com.vasilv.binance.symbol.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<SymbolDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("symbol.db")
    return Room.databaseBuilder<SymbolDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}