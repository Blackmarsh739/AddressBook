package addressBookOperation.request

import Contact
import Group
import java.util.UUID


data class AddContactCreateRequest(
    val firstName: String,
    val lastName: String,
    val emails: MutableMap<String, String>,
    val phoneNumber: MutableMap<String, String>,
    val address: MutableMap<String, String>,
    val groups: MutableList<String>
)

data class UpdateContactRequest(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val emails: MutableMap<String, String>,
    val phoneNumber: MutableMap<String, String>,
    val address: MutableMap<String, String>,
    val groups: MutableList<String>
)

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
data class AddGroupRequest(
    val groupName: String,
    val groupMember: MutableList<Contact>
)
fun AddGroupRequest.toGroups() = Group(
    Gid = UUID.randomUUID(),
    groupName = this@toGroups.groupName,
    groupInfo = this@toGroups.groupMember
)

data class UpdateGroupRequest(
    val groupId: UUID,
    val groupName:String,
    val groupMember: MutableList<Contact>
)
fun UpdateGroupRequest.toGroup() = Group(
    Gid = this@toGroup.groupId,
    groupName = this@toGroup.groupName,
    groupInfo = this@toGroup.groupMember
)
