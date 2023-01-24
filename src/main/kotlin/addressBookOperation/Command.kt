package addressBookOperation

import Contact
import Group
import java.lang.reflect.Member
import java.util.*

interface Command {
    fun execute(): Any
}

fun AddContactCreateRequest.toContact() =
    Contact(
        id = UUID.randomUUID(),
        firstName = this@toContact.firstName,
        lastName = this@toContact.lastName,
        emails = this@toContact.emails,
        phoneNumber = this@toContact.phoneNumber,
        address = this@toContact.address,
        groups = this@toContact.groups

    )

fun UpdateContactRequest.toContact() =
    Contact(
        id = UUID.randomUUID(),
        firstName = this@toContact.firstName,
        lastName = this@toContact.lastName,
        emails = this@toContact.emails,
        phoneNumber = this@toContact.phoneNumber,
        address = this@toContact.address,
        groups = this@toContact.groups

    )

class AddContactCommand(
    private val request: AddContactCreateRequest
) : Command {
    override fun execute(): Contact {
        return Storage.addContact(request.toContact())
    }
}
class DeleteContactCommand(
    private val request: UUID
): Command{
    override fun execute(): Contact {
        return Storage.removeContact(request)!!
    }
}

class UpdateContactCommand(
    private val request: UpdateContactRequest
) : Command{
    override fun execute(): Any {
        return Storage.updateContact(request)
    }
}

class SearchContactCommand(
    private val query: String
): Command{
    override fun execute(): List<Contact> {
        return Storage.searchContacts(query)
    }
}

class AddGroupCommand(
    private val request: AddGroupRequest
): Command {
    override fun execute(): Group = Storage.addGroup(request.toGroups())

}
class ShowGroupsCommand: Command{
    override fun execute(): Collection<Group> {
       return Storage.showGroups()
    }
}
