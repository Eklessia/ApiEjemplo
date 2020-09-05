package cl.grupo2.restapidesafio.data.remote

import cl.grupo2.restapidesafio.domain.model.Contacto
import io.reactivex.Single
import retrofit2.http.GET

interface ContactoApi {
    @GET("users")
    fun getContactoApi() : Single<List<Contacto>>
}