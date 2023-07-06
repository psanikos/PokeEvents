package com.simpletech.data.storage.realm_objects

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId
import java.time.Instant
import java.util.Date

open class PokemonRealmEntity : RealmObject {
    @PrimaryKey
    var dateAdded = Instant.now().toEpochMilli()
    var height: Long? = null
    var id: Long? = null
    var name: String? = null
    var order: Long? = null
    var sprites: SpritesRealmEntity? = null
    var weight: Long? = null
}

open class SpritesRealmEntity : RealmObject {
    var frontDefault: String? = null
    var other: OtherRealmEntity? = null
}

open class OfficialArtworkRealmEntity : RealmObject {
    var frontDefault: String? = null
}

open class OtherRealmEntity : RealmObject {
    var officialArtwork: OfficialArtworkRealmEntity? = null
}
