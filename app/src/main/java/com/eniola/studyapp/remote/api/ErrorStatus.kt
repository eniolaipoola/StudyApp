package com.eniola.studyapp.remote.api

class ErrorStatus {
    companion object {
        const val NO_CONNECTION = "Not Connected To The Internet"
        const val UNAUTHORIZED = "You are not Authorized to perform this action"
        const val TIMEOUT = "Request has been Timed out"
        const val EMPTY_RESPONSE = "No data found"
    }
}
