package cl.grupo2.restapidesafio.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import cl.grupo2.network.RetrofitHandler
import cl.grupo2.restapidesafio.R
import cl.grupo2.restapidesafio.data.remote.RemoteContactoRepository
import cl.grupo2.restapidesafio.databinding.FragmentListadoContactosBinding
import cl.grupo2.restapidesafio.domain.GetAllContactosUseCase
import cl.grupo2.restapidesafio.domain.model.Contacto
import cl.grupo2.restapidesafio.presentation.ContactoAdapter
import cl.grupo2.restapidesafio.presentation.ContactoItemListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListadoContactosFragment : Fragment(R.layout.fragment_listado_contactos), ContactoItemListener {
    private lateinit var getAllContactosUseCase : GetAllContactosUseCase
    private lateinit var binding: FragmentListadoContactosBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListadoContactosBinding.bind(view)
        setupRecyclerView()
        setupUseCase()
    }

    @SuppressLint("CheckResult")
    private fun setupUseCase() {
        val repository = RemoteContactoRepository(RetrofitHandler.getContactoApi())
        getAllContactosUseCase = GetAllContactosUseCase(repository)
        getAllContactosUseCase
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                handleResult(result)
            }, { error ->
                handleError(error)
            })
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()

    }

    private fun handleResult(result: List<Contacto>) {
        binding.rvListadoContacto.adapter = ContactoAdapter(result, this)

    }

    private fun setupRecyclerView() {
        binding.apply {
            rvListadoContacto.setHasFixedSize(true)
            rvListadoContacto.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onContactoItemClick(contacto: Contacto) {
        Toast.makeText(requireContext(), contacto.name, Toast.LENGTH_LONG).show()
    }
}