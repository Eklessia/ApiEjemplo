package cl.grupo2.restapidesafio.domain

import cl.grupo2.restapidesafio.domain.model.Contacto
import io.reactivex.Single

interface ContactoRepository {
    fun getContactos(): Single<List<Contacto>>
}