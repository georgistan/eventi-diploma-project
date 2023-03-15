package com.example.eventi.ui.app.components.analytics_screen

import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.eventi.R
import com.example.eventi.ui.theme.*
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.ArrayList

@Composable
fun PieChart(
    modifier: Modifier
){
    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.chart_description),
                style = EventiTypography.subtitle2
            )
            Column(
                modifier = modifier
                    .padding(18.dp)
                    .size(320.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Crossfade(targetState = getPieChartData) { pieChartData ->
                    AndroidView(
                        factory = { context ->
                            PieChart(context).apply {
                                layoutParams = LinearLayout.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                )
                                this.description.isEnabled = false
                                this.isDrawHoleEnabled = false
                                this.legend.isEnabled = true
                                this.legend.textSize = 14F
                                this.legend.horizontalAlignment =
                                    Legend.LegendHorizontalAlignment.CENTER
                                this.setEntryLabelColor(R.color.white)
                            }
                        },
                        modifier = modifier
                            .wrapContentSize()
                            .padding(5.dp),
                        update = {
                            updatePieChartWithData(it, pieChartData)
                        }
                    )
                }
            }
        }
    }
}

fun updatePieChartWithData(
    chart: PieChart,
    data: List<PieChartData>
) {
    val entries = ArrayList<PieEntry>()

    for (i in data.indices) {
        val item = data[i]
        entries.add(PieEntry(item.attendedEventsOfCategory ?: 0.toFloat(), item.eventCategory ?: ""))
    }

    val ds = PieDataSet(entries, "")

    ds.colors = arrayListOf(
        PrimaryBlue.toArgb(),
        PrimaryOrange.toArgb(),
        ValidationGreen.toArgb(),
        PrimaryGray.toArgb(),
    )
    ds.yValuePosition = PieDataSet.ValuePosition.INSIDE_SLICE
    ds.xValuePosition = PieDataSet.ValuePosition.INSIDE_SLICE
    ds.sliceSpace = 2f
    ds.valueTextColor = R.color.white
    ds.valueTextSize = 16f
    ds.valueTypeface = Typeface.DEFAULT_BOLD

    val d = PieData(ds)

    chart.data = d

    chart.invalidate()
}