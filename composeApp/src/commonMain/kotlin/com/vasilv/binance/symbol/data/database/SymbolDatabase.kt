package com.vasilv.binance.symbol.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(
    entities = [SymbolEntity::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class SymbolDatabase : RoomDatabase() {
    abstract fun symbolDao(): SymbolDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<SymbolDatabase> {
    override fun initialize(): SymbolDatabase
}