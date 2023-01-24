package addressBookOperation

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
data class AddGroupRequest(
    val groupName: String,
    val groupMember: MutableList<Contact>
)
fun AddGroupRequest.toGroups() = Group(
    Gid = UUID.randomUUID(),
    groupName = this@toGroups.groupName,
    groupInfo = this@toGroups.groupMember
)
