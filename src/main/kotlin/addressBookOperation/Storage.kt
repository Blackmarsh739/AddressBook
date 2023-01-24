package addressBookOperation

import Contact
import Group
import java.util.UUID


object  Storage {
    private val contacts: MutableMap<UUID, Contact> = mutableMapOf()
    private val groups: MutableMap<UUID, Group> = mutableMapOf()

    fun addContact(contact: Contact): Contact {
        contacts[contact.id] = contact
        contact.groups.forEach { groupName ->
            val group = groups.values.find { it.groupName==groupName }
            if (group!=null){
                group.groupInfo.add(contact)
                groups[group.Gid]=group
            }else{
                val newGroup=Group(UUID.randomUUID(),groupName, mutableListOf(contact))
                groups[newGroup.Gid]=newGroup
            }
        }
//        return contacts[contact.id]!!
        return contact
    }

    fun addGroup(group: Group): Group{
        groups[group.Gid]=group
        group.groupInfo.forEach{
            val contact = contacts[it.id]
            if(contact!=null){
                contact.groups.add(group.groupName)
                contacts[it.id]=contact
            }
        }
        return group
    }

    fun updateContact(request: UpdateContactRequest): Contact {
        contacts[request.id] = request.toContact()
        return contacts[request.id]!!
    }

    fun removeContact(id: UUID): Contact?{
        return contacts.remove(id)
    }

    fun listAllContacts(){
        println("\n" + "---------Contact List------------")
        contacts.forEach {
            println(it)
        }
    }
    fun searchContacts(query: String): List<Contact> {
        val foundContact: MutableList<Contact> = mutableListOf()
        for (contact in contacts){
            if (
                contact.value.firstName.contains(query,ignoreCase = true) ||
                contact.value.lastName.contains(query,ignoreCase = true) ||
                ("${contact.value.firstName.contains(query,ignoreCase = true)}" + " " + "${contact.value.lastName.contains(query,ignoreCase = true)}").toBoolean() ||
                contact.value.phoneNumber.values.contains(query)

                    )
                foundContact.add(contact.value)
        }
        return foundContact.toList()
    }
    fun showGroups(): Collection<Group>{
        return groups.values
    }
}
