import java.util.UUID

data class Contact(
    val id: UUID,
    val firstName: String,
    val lastName: String,

    val emails: MutableMap<String, String>,
    val phoneNumber: MutableMap<String, String>,
    val address: MutableMap<String, String>,
    val groups: MutableList<String>

)

data class Group(
    val Gid: UUID,
    val groupName: String,
    val groupInfo: MutableList<Contact>
)