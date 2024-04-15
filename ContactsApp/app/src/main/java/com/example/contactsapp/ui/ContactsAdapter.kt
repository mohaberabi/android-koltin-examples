package com.example.contactsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.R
import com.example.contactsapp.data.model.Contact
import com.example.contactsapp.databinding.ContactCardBinding

class ContactAdapter(
    private val onClick: (Contact) -> Unit
) :
    RecyclerView.Adapter<ContactViewHolder>() {
    private val contacts: ArrayList<Contact> = ArrayList()


    fun setContacts(newContacts: List<Contact>) {

        contacts.clear()
        contacts.addAll(newContacts)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ): ContactViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ContactCardBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.contact_card,
            parent,
            false
        )


        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int = contacts.size


    override fun onBindViewHolder(
        holder: ContactViewHolder, position: Int
    ) {
        val contact = contacts[position]
        holder.bind(
            contact,
            onClick = onClick
        )


    }

}


class ContactViewHolder(
    private val binding: ContactCardBinding,
) :
    RecyclerView.ViewHolder(
        binding.root
    ) {

    fun bind(
        contact: Contact,
        onClick: (Contact) -> Unit,
    ) {
        binding.contact = contact
        binding.contactCard.setOnClickListener {
            onClick(contact)
        }
    }


}


