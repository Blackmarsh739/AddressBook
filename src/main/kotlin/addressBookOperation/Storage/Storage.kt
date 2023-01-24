package addressBookOperation.Storage

import Contact
import Group
import addressBookOperation.request.UpdateContactRequest
import addressBookOperation.request.UpdateGroupRequest
import addressBookOperation.request.toContact
import addressBookOperation.request.toGroup
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

    fun updateGroup(request: UpdateGroupRequest): Group {
        groups[request.groupId] = request.toGroup()
        return groups[request.groupId]!!
    }

    fun updateContact(request: UpdateContactRequest): Contact {
        contacts[request.id] = request.toContact()
        return contacts[request.id]!!
    }

    fun removeContact(id: UUID): Contact?{
        val contact = contacts[id]
        contact?.groups?.forEach { groupName ->
            val group = groups.values.find { it.groupName==groupName }
            if (group!=null){
                group.groupInfo.remove(contact)
                groups[group.Gid]=group
            }
        }

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

    fun removeGroup(gId: UUID): Group?{
        return groups.remove(gId)
    }
    fun searchGroups(query: String): List<Group> {
        val foundGroup: MutableList<Group> = mutableListOf()
        for (group in groups){
            if (
                group.value.groupName.contains(query,ignoreCase = true)
            )
                foundGroup.add(group.value)
        }
        return foundGroup.toList()
    }
}

