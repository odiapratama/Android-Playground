package com.playground.core.ui.navigation

interface NavSpace<O: NavOrbit<*>, P: NavPortal, S: NavSatellite> {
    val orbit: O
    val portal: P
    val satellite: S
}