package com.example.lecture1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Message(
    val name: String,
    val message: String,
    val time: String,
    val unreadCount: Int = 5,
    val email: String = "giga.btu@edu.ge",
    val phoneNumber: String = "+995599999999",
    val messageType: MessageType
) : Parcelable

@Parcelize
enum class MessageType:  Parcelable {
    Unread,
    Typing,
    Voice,
    Attachment
}
