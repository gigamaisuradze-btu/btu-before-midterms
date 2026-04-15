package com.example.lecture1

import com.example.lecture1.model.Message
import com.example.lecture1.model.MessageType

object DataFactory {
    val messages = listOf(
        Message(
            name = "Alice Smith",
            message = "Hey, how are you?",
            time = "09:10 AM",
            unreadCount = 3,
            messageType = MessageType.Unread
        ),
        Message(
            name = "Bob Johnson",
            message = "Check this out!",
            time = "09:15 AM",
            messageType = MessageType.Attachment
        ),
        Message(
            name = "Charlie Brown",
            message = "Voice message",
            time = "09:20 AM",
            messageType = MessageType.Voice
        ),
        Message(
            name = "Diana Prince",
            message = "Typing...",
            time = "09:25 AM",
            messageType = MessageType.Typing
        ),
        Message(
            name = "Ethan Hunt",
            message = "Mission details",
            time = "09:30 AM",
            unreadCount = 1,
            messageType = MessageType.Unread
        ),
        Message(
            name = "Fiona Gallagher",
            message = "See you soon",
            time = "09:35 AM",
            messageType = MessageType.Attachment
        ),
        Message(
            name = "George Martin",
            message = "New draft ready",
            time = "09:40 AM",
            messageType = MessageType.Voice
        ),
        Message(
            name = "Hannah Lee",
            message = "Typing...",
            time = "09:45 AM",
            messageType = MessageType.Typing
        ),
        Message(
            name = "Ivan Petrov",
            message = "Let’s meet",
            time = "09:50 AM",
            unreadCount = 2,
            messageType = MessageType.Unread
        ),
        Message(
            name = "Jessica Alba",
            message = "Sent a file",
            time = "09:55 AM",
            messageType = MessageType.Attachment
        ),
        Message(
            name = "Kevin Hart",
            message = "Voice note",
            time = "10:00 AM",
            messageType = MessageType.Voice
        ),
        Message(
            name = "Laura Palmer",
            message = "Typing...",
            time = "10:05 AM",
            messageType = MessageType.Typing
        ),
        Message(
            name = "Michael Scott",
            message = "That’s what she said",
            time = "10:10 AM",
            unreadCount = 5,
            messageType = MessageType.Unread
        ),
        Message(
            name = "Nancy Drew",
            message = "Found something interesting",
            time = "10:15 AM",
            messageType = MessageType.Attachment
        ),
        Message(
            name = "Oscar Isaac",
            message = "Voice msg",
            time = "10:20 AM",
            messageType = MessageType.Voice
        ),
        Message(
            name = "Pam Beesly",
            message = "Typing...",
            time = "10:25 AM",
            messageType = MessageType.Typing
        ),
        Message(
            name = "Quentin Tarantino",
            message = "New idea",
            time = "10:30 AM",
            unreadCount = 7,
            messageType = MessageType.Unread
        ),
        Message(
            name = "Rachel Green",
            message = "Look at this!",
            time = "10:35 AM",
            messageType = MessageType.Attachment
        ),
        Message(
            name = "Steve Rogers",
            message = "Voice update",
            time = "10:40 AM",
            messageType = MessageType.Voice
        ),
        Message(
            name = "Tony Stark",
            message = "Typing...",
            time = "10:45 AM",
            messageType = MessageType.Typing
        )
    )
}