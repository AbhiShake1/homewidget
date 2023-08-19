package com.app.homewidget.receivers

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.app.homewidget.widgets.CounterWidget

class CounterReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = CounterWidget
}