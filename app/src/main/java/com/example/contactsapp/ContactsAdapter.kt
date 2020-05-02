package com.example.contactsapp

import android.content.Context
import android.content.Intent
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contacts_list.view.*

class ContactsAdapter(var context: Context, var contacts :ArrayList<MyContacts>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
        LayoutInflater.from(
            context)
            .inflate(R.layout.contacts_list,
                parent,
            false
        )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=contacts.get(position).name
        holder.image.setImageResource(contacts.get(position).image)

        holder.itemView.setOnClickListener {
            Toast.makeText(context,"call ${contacts.get(position).name}"
                ,Toast.LENGTH_SHORT).show()


            val intent=Intent(context,Details::class.java)
            context.startActivity(intent)

            intent.putExtra("name",contacts.get(position).name)
            intent.putExtra("email",contacts.get(position).email)
            intent.putExtra("phone",contacts.get(position).phone)
            intent.putExtra("image",contacts.get(position).image.toString())
            intent.putExtra("address",contacts.get(position).address)
        }
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val name= view.name
        val email= view.name
        val phone= view.name
        val image= view.userimage
        val address= view.address

    }
}
