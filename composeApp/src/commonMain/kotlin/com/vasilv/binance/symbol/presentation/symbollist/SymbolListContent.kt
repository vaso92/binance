package com.vasilv.binance.symbol.presentation.symbollist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.presentation.components.bottomFadingEdge
import com.vasilv.binance.symbol.presentation.components.topFadingEdge
import com.vasilv.binance.symbol.presentation.constants.Paddings

@Composable
fun SymbolListContent(
    isLoading: Boolean,
    items: List<Symbol>,
    onSymbolClick: (Symbol) -> Unit
) {
    if (isLoading) {
        LazyColumn(
            Modifier
                .padding(horizontal = Paddings.SIDE_PADDING)
                .shimmer()
        ) {
            items(20) {
                ShimmerListItem(
                    modifier = Modifier.fillMaxWidth()
                )
                Divider(modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    } else {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            modifier = Modifier
                .topFadingEdge(
                    color = MaterialTheme.colors.surface,
                    isVisible = listState.canScrollBackward
                )
                .bottomFadingEdge(
                    color = MaterialTheme.colors.surface,
                    isVisible = listState.canScrollForward
                )
                .padding(horizontal = Paddings.SIDE_PADDING)
        ) {
            items(items) {
                SymbolListItem(
                    symbol = it,
                    modifier = Modifier.fillMaxWidth().clickable { onSymbolClick(it) }
                )
                Divider(modifier = Modifier.padding(vertical = 10.dp))
            }
        }
    }
}

@Composable
private fun SymbolListItem(
    symbol: Symbol,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            Text(text = symbol.symbol)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = symbol.priceChangePercent)
        }

        Row {
            Text(text = "bid/ask:")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "${symbol.bidPrice}/${symbol.askPrice}")
        }
    }
}

@Composable
private fun ShimmerListItem(
    modifier: Modifier = Modifier
) {
    val textSize = with(LocalDensity.current) {
        LocalTextStyle.current.fontSize.value.toDp()
    }

    Column(modifier = modifier) {
        Row {
            Box(
                Modifier.width(100.dp)
                    .height(textSize)
                    .background(
                        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                Modifier.width(100.dp)
                    .height(textSize)
                    .background(
                        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
                    )
            )
        }

        Row {
            Box(
                Modifier.width(100.dp)
                    .height(textSize)
                    .background(
                        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
                    )
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                Modifier.width(100.dp)
                    .height(textSize)
                    .background(
                        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
                    )
            )
        }
    }
}