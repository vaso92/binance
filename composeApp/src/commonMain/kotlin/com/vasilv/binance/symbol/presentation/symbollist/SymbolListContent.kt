package com.vasilv.binance.symbol.presentation.symbollist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import com.vasilv.binance.symbol.domain.model.Symbol
import com.vasilv.binance.symbol.presentation.components.bottomFadingEdge
import com.vasilv.binance.symbol.presentation.components.topFadingEdge
import com.vasilv.binance.symbol.presentation.constants.Paddings

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SymbolListContent(
    isLoading: Boolean,
    isRefreshing: Boolean,
    items: List<Symbol>,
    onSymbolClick: (Symbol) -> Unit,
    onRefresh: () -> Unit
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = onRefresh
    )

    Box(modifier = Modifier.fillMaxSize()) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            modifier = Modifier
                .pullRefresh(pullRefreshState)
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
            if (!isLoading) {
                items(items) {
                    SymbolListItem(
                        isLoading = isLoading,
                        symbol = it,
                        modifier = Modifier.fillMaxWidth().clickable { onSymbolClick(it) }
                    )
                    Divider(modifier = Modifier.padding(vertical = 10.dp))
                }
            } else {
                items(50) {
                    SymbolListItem(
                        isLoading = isLoading,
                        symbol = Symbol(
                            askPrice = "0.03921000",
                            askQty = "24.59300000",
                            bidPrice = "0.03920000",
                            bidQty = "28.21340000",
                            closeTime = 1728454292718,
                            count = 74314,
                            firstId = 469155407,
                            highPrice = "0.03958000",
                            lastId = 469229720,
                            lastPrice = "0.03921000",
                            lastQty = "8.79620000",
                            lowPrice = "0.03874000",
                            openPrice = "0.03877000",
                            openTime = 1728367892718,
                            prevClosePrice = "0.03877000",
                            priceChange = "0.00044000",
                            priceChangePercent = "1.135",
                            quoteVolume = "676.45638013",
                            symbol = "ETHBTC",
                            volume = "17301.24930000",
                            weightedAvgPrice = "0.03909870"
                        ),
                        modifier = Modifier.fillMaxWidth().shimmer()
                    )
                    Divider(modifier = Modifier.padding(vertical = 10.dp))
                }
            }
        }

        PullRefreshIndicator(
            refreshing = isRefreshing,
            state = pullRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
            backgroundColor = if (isRefreshing) Color.Red else Color.Green,
        )
    }
}

@Composable
private fun SymbolListItem(
    isLoading: Boolean,
    symbol: Symbol,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row {
            ShimmerObject(isShimmering = isLoading) { Text(text = symbol.symbol) }
            Spacer(modifier = Modifier.weight(1f))
            ShimmerObject(isShimmering = isLoading) { Text(text = symbol.priceChangePercent) }
        }

        Row {
            ShimmerObject(isShimmering = isLoading) { Text(text = "bid/ask:") }
            Spacer(modifier = Modifier.weight(1f))
            ShimmerObject(isShimmering = isLoading) { Text(text = "${symbol.bidPrice}/${symbol.askPrice}") }
        }
    }
}

@Composable
private fun ShimmerObject(
    isShimmering: Boolean,
    color: Color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
    content: @Composable () -> Unit
) {
    if (isShimmering) {
        Layout(
            content = content,
            modifier = Modifier.drawBehind {
                drawRect(
                    color = color,
                    size = this.size
                )
            }
        ) { measurables, constraints ->
            val placeable = measurables.first().measure(constraints)

            val width = placeable.width
            val height = placeable.height

            layout(width, height) {
            }
        }
    } else {
        content()
    }
}
