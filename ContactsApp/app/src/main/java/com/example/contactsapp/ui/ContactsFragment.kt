package com.example.contactsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.contactsapp.R
import com.example.contactsapp.data.database.ContactDatabase
import com.example.contactsapp.data.model.Contact
import com.example.contactsapp.databinding.FragmentContactsBinding
import com.example.contactsapp.repository.ContactRepository
import com.example.contactsapp.viewmodel.ContactViewModel
import com.example.contactsapp.viewmodel.ContactViewModelFactory


class ContactsFragment : Fragment() {

    private lateinit var viewModel: ContactViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dao = ContactDatabase.getInstance(requireContext()).contactsDao
        val contactRepository = ContactRepository(dao)
        val factory = ContactViewModelFactory(contactRepository)
        viewModel = ViewModelProvider(this, factory)[ContactViewModel::class.java]


        val binding: FragmentContactsBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_contacts,
                container,
                false
            )
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val adapter = ContactAdapter {
            onItemPressed(it)
        }
        binding.recView.adapter = adapter

        viewModel.contacts.observe(viewLifecycleOwner) {
            adapter.setContacts(it)
            adapter.notifyDataSetChanged()
        }

        viewModel.statusMessage.observe(viewLifecycleOwner) {
            it.getWhenNotDone()?.let { message ->
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun onItemPressed(contact: Contact) = viewModel.chooseContact(contact)


}