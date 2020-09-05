package cl.grupo2.restapidesafio.presentation

import cl.grupo2.restapidesafio.domain.model.Contacto

interface ContactoItemListener {
    fun onContactoItemClick(contacto: Contacto)
}