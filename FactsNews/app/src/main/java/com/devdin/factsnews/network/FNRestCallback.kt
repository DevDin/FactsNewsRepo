package com.devdin.factsnews.network

interface FNRestCallback<T> {
    fun onSuccess(response:T?)
    fun onFailure()
}