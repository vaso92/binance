package com.vasilv.binance.symbol.data.database

import androidx.room.Room
import androidx.room.RoomDatabase
import java.io.File

fun getDatabaseBuilder(): RoomDatabase.Builder<SymbolDatabase> {
    val dbFile = File(System.getProperty("java.io.tmpdir"), "symbol.db")
    return Room.databaseBuilder<SymbolDatabase>(
        name = dbFile.absolutePath,
    )
}