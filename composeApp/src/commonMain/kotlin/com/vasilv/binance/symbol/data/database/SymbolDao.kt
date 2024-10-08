package com.vasilv.binance.symbol.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SymbolDao {
    @Query("SELECT * FROM SymbolsTable")
    fun getSymbols(): Flow<List<SymbolEntity>>

    @Insert
    suspend fun insertSymbols(symbolsList: List<SymbolEntity>)

    @Query(value = "DELETE FROM SymbolsTable")
    suspend fun deleteAll()

    @Transaction
    suspend fun replaceSymbols(symbolsList: List<SymbolEntity>) {
        deleteAll()
        insertSymbols(symbolsList)
    }

    @Upsert
    suspend fun upsertSymbol(symbolEntity: SymbolEntity)
}
