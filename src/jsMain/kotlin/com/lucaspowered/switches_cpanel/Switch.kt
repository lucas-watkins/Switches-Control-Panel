package com.lucaspowered.switches_cpanel

import io.kvision.core.AlignItems
import io.kvision.core.Background
import io.kvision.core.Col
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
import io.kvision.panel.hPanel

class Switch(private val switchID: Int) : Drawable() {

    companion object {
        val switchService = getService<ISwitchService>()
        val requestsService = getService<IRequestsService>()

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
                    hPanel(spacing = 5) {
                        button("On") {
                            size = ButtonSize.SMALL
                            style = ButtonStyle.PRIMARY
                            background = Background(Color.name(Col.GREEN))
                        }.onClick {
                            console.log("Switch $switchID on")
                            sendRequest("on")
                        }

                        button("Off") {
                            size = ButtonSize.SMALL
                            style = ButtonStyle.PRIMARY
                            background = Background(Color.name(Col.RED))
                        }.onClick {
                            console.log("Switch $switchID off")
                            sendRequest("off")
                        }

                        button("Toggle") {
                            size = ButtonSize.SMALL
                            style = ButtonStyle.PRIMARY
                        }.onClick {
                            console.log("Switch $switchID toggled")
                            sendRequest("toggle")
                        }
                    }
                }
            }
        }
    }

    private fun sendRequest(mode: String) {
        AppScope.launch { requestsService.httpGet("${switchService.getUrl(switchID)}/$mode") }
    }
}