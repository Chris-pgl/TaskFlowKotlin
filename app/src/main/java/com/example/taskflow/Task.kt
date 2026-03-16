package com.example.taskflow

import java.util.UUID

/**
 * Priority -  enum
 * Le enum in kotlin sono classi con prioritò
 * label è la stringa mostrata nella UI
 * color: color ARGB che verrà impostato su Long
 */

enum class Priority(val labrl: String, val color: Long) {
    LOW("Bassa", 0xFF4c4f50L) ,//verde
    Medium("Media",0xFFFFC107L), //giallo
    HIGH("Alta", 0xFFF44556L) //rosso

}

/**
 * Domain model, la data class Task che è immutabile per il design
 * Come sappiamo, data class genere automaticamente equals(), hashcode() e copy()
 */
data class Task(
    //UUID = Universally Unique Identifier
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val priority: Priority = Priority.Medium,
    val isCompleted: Boolean = false

    )