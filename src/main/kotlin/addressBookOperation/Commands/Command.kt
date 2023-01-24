package addressBookOperation.Commands

import Contact
import Group
import addressBookOperation.Storage.Storage
import addressBookOperation.request.*
import java.util.*

interface Command {
    fun execute(): Any
}

class AddContactCommand(
    private val request: AddContactCreateRequest
) : Command {
    override fun execute(): Contact {
        return Storage.addContact(request.toContact())
    }
}
class DeleteContactCommand(
    private val request: UUID
): Command {
    override fun execute(): Contact {
        return Storage.removeContact(request)!!
    }
}

class UpdateContactCommand(
    private val request: UpdateContactRequest
) : Command {
    override fun execute(): Any {
        return Storage.updateContact(request)
    }
}

class SearchContactCommand(
    private val query: String
): Command {
    override fun execute(): List<Contact> {
        return Storage.searchContacts(query)
    }
}

class AddGroupCommand(
    private val request: AddGroupRequest
): Command {
    override fun execute(): Group = Storage.addGroup(request.toGroups())

}
class ShowGroupsCommand: Command {
    override fun execute(): Collection<Group> {
       return Storage.showGroups()
    }
}
class UpdateGroupCommand(
    private val request: UpdateGroupRequest
): Command {
    override fun execute(): Any {
        return Storage.updateGroup(request)
    }

}class DeleteGroupContact(
    private val request: UUID
): Command {
    override fun execute(): Any {
        return Storage.removeGroup(request)!!
    }

}
class SearchGroupCommand(
    private val query: String
): Command {
    override fun execute(): List<Group> {
        return Storage.searchGroups(query)
    }

}


