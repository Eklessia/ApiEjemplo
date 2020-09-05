package cl.grupo2.restapidesafio.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.grupo2.restapidesafio.R
import cl.grupo2.restapidesafio.domain.model.Contacto
import cl.grupo2.restapidesafio.ui.ListadoContactosFragment

class ContactoAdapter(
    private val contactos: List<Contacto>,
    private val listener: ListadoContactosFragment?
) : RecyclerView.Adapter<ContactoVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.users_list_card, parent, false)
        return ContactoVH(view, listener)
    }

    override fun getItemCount() = contactos.size

    override fun onBindViewHolder(holder: ContactoVH, position: Int) {
        holder.bind(contactos[position])
    }
}