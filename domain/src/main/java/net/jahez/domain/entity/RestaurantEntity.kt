package net.jahez.domain.entity

data class RestaurantEntity(
    val id: Int?,
    val description: String?,
    val distance: Double?,
    val hasOffer: Boolean?,
    val hours: String?,
    val image: String?,
    val name: String?,
    val offer: String?,
    val rating: Double?
)