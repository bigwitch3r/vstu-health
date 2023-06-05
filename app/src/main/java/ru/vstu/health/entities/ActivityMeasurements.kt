package ru.vstu.health.entities

import kotlinx.serialization.Serializable

@Serializable
data class ActivityMeasurements(val dateTime: kotlinx.datetime.LocalDateTime, val aX: Int, val aY: Int, val aZ: Int)