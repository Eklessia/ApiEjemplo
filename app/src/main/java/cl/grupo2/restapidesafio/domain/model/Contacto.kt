package cl.grupo2.restapidesafio.domain.model

import com.google.gson.annotations.SerializedName


data class Contacto(
    @SerializedName("id") val id: Int,
    @SerializedName ("name") val name: String,
    @SerializedName ("email") val email: String,
    @SerializedName("phone") val phone: String
)