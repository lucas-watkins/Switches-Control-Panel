package com.lucaspowered.switches_cpanel
import io.kvision.panel.SimplePanel

abstract class Drawable : SimplePanel() {
    abstract fun draw()
    init { draw() }
}