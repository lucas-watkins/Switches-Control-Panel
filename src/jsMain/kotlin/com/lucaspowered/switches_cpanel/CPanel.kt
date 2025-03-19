package com.lucaspowered.switches_cpanel

import io.kvision.html.button
import io.kvision.html.label
import kotlinx.browser.localStorage
import com.lucaspowered.switches_cpanel.jsutils.reloadPage
import io.kvision.core.AlignItems
import io.kvision.core.Background
import io.kvision.core.Color
import io.kvision.core.TextAlign
import io.kvision.core.widget
import io.kvision.html.div
import io.kvision.panel.hPanel
import io.kvision.panel.vPanel
import io.kvision.utils.px

class CPanel : Drawable() {
    override fun draw() {
        vPanel(spacing = 10, alignItems = AlignItems.CENTER) {
            label("Switches") {
                textAlign = TextAlign.CENTER
                alignSelf = AlignItems.CENTER
                fontSize = 36.px
            }

            hPanel(spacing = 10, alignItems = AlignItems.CENTER) {
                add(Switch(0))
            }

            button("Logout").onClick {
                localStorage.clear()
                reloadPage()
            }
        }
    }
}