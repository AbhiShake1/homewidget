package com.app.homewidget.widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.text.Text
import coil.compose.AsyncImage

object CounterWidget : GlanceAppWidget() {
    val key = intPreferencesKey("count_key")

    @Composable
    override fun Content() {
        val count = currentState(key = key) ?: 0
        Column(
            modifier = GlanceModifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.Horizontal.CenterHorizontally
        ) {
            Text(text = "Current count: $count")
            Button(text = "+", onClick = actionRunCallback<IncrementAction>())
            AsyncImage(
                model = "https://play-lh.googleusercontent.com/Xh_OlrdkF1UnGCnMN__4z-yXffBAEl0eUDeVDPr4UthOERV4Fll9S-TozSfnlXDFzw",
                contentDescription = "Logo"
            )
        }
    }
}

class IncrementAction : ActionCallback {
    override suspend fun onAction(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        updateAppWidgetState(context, glanceId) { pref ->
            val current = pref[CounterWidget.key] ?: 0
            pref[CounterWidget.key] = current + 1
        }
        CounterWidget.update(context, glanceId)
    }
}