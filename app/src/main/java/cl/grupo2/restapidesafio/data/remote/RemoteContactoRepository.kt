package cl.grupo2.restapidesafio.data.remote

import cl.grupo2.restapidesafio.domain.ContactoRepository
import cl.grupo2.restapidesafio.domain.model.Contacto
import io.reactivex.Single

class RemoteContactoRepository(private val contactoApi: ContactoApi) : ContactoRepository {

    override fun getContactos(): Single<List<Contacto>> {
        return contactoApi.getContactoApi()
    }
}