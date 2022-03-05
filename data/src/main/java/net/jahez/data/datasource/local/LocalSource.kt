package net.jahez.data.datasource.local

import android.content.Context
import net.jahez.data.db.JahezDatabase
import javax.inject.Inject

abstract class LocalSource constructor() {
    @Inject
    lateinit var db: JahezDatabase

    @Inject
    lateinit var context: Context
}