package com.lucaspowered.switches_cpanel

import io.kvision.html.button
import io.kvision.html.label
import kotlinx.browser.localStorage
import com.lucaspowered.switches_cpanel.jsutils.reloadPage
import io.kvision.core.AlignItems
import io.kvision.core.TextAlign
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.utils.px
import kotlinx.coroutines.launch

class CPanel : Drawable() {
    override fun draw() {
        vPanel(spacing = 10, alignItems = AlignItems.CENTER) {
            label("Switches") {
                textAlign = TextAlign.CENTER
                alignSelf = AlignItems.CENTER
                fontSize = 36.px
            }

            hPanel(spacing = 10, alignItems = AlignItems.CENTER) {
                AppScope.launch {
                    val count = Switch.getCount()
                    if (count > 0) {
                        for (i in 0..count - 1) {
                            add(Switch(i))
                        }
                    } else {
                        label("You Currently Don't Have Any Switches Set Up") {
                            fontSize = 25.px
                        }
                    }
                }
                paddingBottom = 15.px
            }

            hPanel(spacing = 5) {
                button("Logout").onClick {
                    localStorage.clear()
                    reloadPage()
                }
            }
        }
    }
}