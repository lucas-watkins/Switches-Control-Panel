package com.lucaspowered.switches_cpanel

import io.kvision.core.AlignItems
import io.kvision.core.Background
import io.kvision.core.Color
import io.kvision.core.onEvent
import io.kvision.core.widget
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.h1
import io.kvision.html.label
import io.kvision.panel.vPanel
import io.kvision.utils.px
import kotlinx.coroutines.launch

class Switch(val url: String) : Drawable() {

    override fun draw() {
        div {
            background = Background(Color.rgb(236, 236, 236))
            borderRadius = 5.px

            vPanel(spacing = 10, alignItems = AlignItems.FLEXSTART) {
                AppScope.launch {
                    label(Config.getUsername())

                    button("Toggle").onClick {
                        console.log("toggled")
                    }
                }
            }
        }
    }

    private fun toggle() {
        TODO()
    }
}