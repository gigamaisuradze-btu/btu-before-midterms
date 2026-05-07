package com.example.lecture1.network

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import java.io.IOException

object Helper {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun <T> makeApiCall(call: suspend () -> T): NetworkResult<T> {
        return try {
            NetworkResult.Success(call())
        } catch (e: HttpException) {
            NetworkResult.Failure(
                message = "Http error",
            )
        } catch (e: IOException) {
            NetworkResult.Failure("No internet connection")
        } catch (e: Exception) {
            NetworkResult.Failure(e.message ?: "Unknown error")
        }
    }
}