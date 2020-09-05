package cl.grupo2.restapidesafio.domain

import cl.grupo2.restapidesafio.domain.model.Contactos
import io.reactivex.Single

interface ContactoRepository {
    fun getContactos(): Single<Contactos>
}