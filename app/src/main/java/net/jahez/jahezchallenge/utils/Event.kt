package net.jahez.jahezchallenge.utils

import androidx.lifecycle.Observer

class Event<out T>(private val data: T?) {

    private var hasBeenHandled = false

    /**
     * Returns the live data content and prevents its use again.
     */
    fun getEventIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            data
        }
    }

    fun peekContent(): T? = data
}

/**
 * Returns the live data content null checked and provide wrapper over Observer.
 */

class EventObserver<T>(private val onUnhandledEvent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getEventIfNotHandled()?.let {
            onUnhandledEvent(it)
        }
    }
}