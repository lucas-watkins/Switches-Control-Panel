package com.lucaspowered.switches_cpanel

import io.kvision.core.AlignItems
import io.kvision.core.Background
import io.kvision.core.Color
import io.kvision.html.button
import io.kvision.html.div
import io.kvision.html.label
import io.kvision.panel.vPanel
import io.kvision.remote.getService
import io.kvision.utils.px
import kotlinx.coroutines.launch
import io.kvision.html.ButtonSize
import io.kvision.html.ButtonStyle

class Switch(private val switchID: Int) : Drawable() {

    companion object {
        private val switchService = getService<ISwitchService>()

        suspend fun getCount(): Int = switchService.getCount()
    }

    override fun draw() {
        div {
            background = Background(Color.rgb(236, 236, 236))
            borderRadius = 5.px
            padding = 10.px

            vPanel(spacing = 0, alignItems = AlignItems.FLEXSTART) {
                AppScope.launch {
                    label(switchService.getName(switchID)) {
                        fontSize = 25.px
                        paddingBottom = 0.px
                    }

                    label(switchService.getUrl(switchID)) {
                        fontSize = 10.px
                        paddingBottom = 5.px
                    }

                    label(switchService.getDesc(switchID)) {
                        fontSize = 15.px
                        paddingBottom = 25.px
                    }

                    button("Toggle"){
                        size = ButtonSize.SMALL
                        style = ButtonStyle.PRIMARY
                    }.onClick {
                        console.log("Switch $switchID toggled")
                    }
                }
            }
        }
    }

    private fun toggle() {

    }
}