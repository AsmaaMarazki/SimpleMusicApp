package com.vama.database

import com.vama.database.albums.entity.AlbumEntity
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.types.TypedRealmObject
import kotlin.reflect.KClass

internal object DatabaseHelper {
    private val schema: Set<KClass<out TypedRealmObject>> = setOf(
        AlbumEntity::class
    )

    val realmConfiguration: RealmConfiguration = RealmConfiguration.create(schema)
}