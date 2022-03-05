package net.jahez.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import net.jahez.data.model.typeconverter.TypeConverterz
import java.io.Serializable

@Entity
@TypeConverters(TypeConverterz::class)
data class RestaurantResponse(
    val list: ArrayList<Restaurant>
): Serializable


@Entity
 data class Restaurant(
    @PrimaryKey
    val id: Int?,
    val description: String?,
    val distance: Double?,
    val hasOffer: Boolean?,
    val hours: String?,
    val image: String?,
    val name: String?,
    val offer: String?,
    val rating: Double?
): Serializable


