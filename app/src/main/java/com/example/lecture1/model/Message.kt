package com.example.lecture1.model


data class Message(
    val name: String,
    val message: String,
    val time: String,
    val unreadCount: Int = 5,
    val email: String = "giga.btu@edu.ge",
    val phoneNumber: String = "+995599999999",
    val messageType: MessageType
)

enum class MessageType {
    Unread,
    Typing,
    Voice,
    Attachment
}
