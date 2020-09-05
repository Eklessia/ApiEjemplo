package cl.grupo2.restapidesafio.domain

class GetAllContactosUseCase (private val repository: ContactoRepository) {

    fun execute() = repository.getContactos()
}