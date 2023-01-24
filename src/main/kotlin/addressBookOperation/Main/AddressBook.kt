package addressBookOperation.Main

//import
import Contact
import Group
import addressBookOperation.Commands.*
import addressBookOperation.Storage.Storage
import addressBookOperation.request.AddContactCreateRequest
import addressBookOperation.request.AddGroupRequest
import addressBookOperation.request.UpdateContactRequest
import addressBookOperation.request.UpdateGroupRequest

class AddressBook {
  var contactList = mutableListOf<Contact>()
    fun executCommand(command: Command): Any {
      return command.execute()

    }

    fun listAllContacts() {
  Storage.listAllContacts()
//      (contactList.map { it -> println("${it.firstName} ${it.lastName} ")})
//      println(contactList.joinToString("\n"))
    }
}

fun main() {

  val addressBookObject = AddressBook()

  val c1 = addressBookObject.executCommand(
    AddContactCommand(
      AddContactCreateRequest("Parth","Raval",
    mutableMapOf("Work" to "parth.raval@vayana.com", "Personal" to "pr73pdpu@gmail.com"),
    mutableMapOf("Work" to "7096447878", "Personal" to "7031013939"),
    mutableMapOf("Office" to "Baroda", "Home" to "Bhavnagar"),
    mutableListOf("Office", "Friends", "Family"))
    )
  ) as Contact
  println(c1)

  val c2 = addressBookObject.executCommand(
    AddContactCommand(
      AddContactCreateRequest("Hamza","Malik",
    mutableMapOf("Work" to "hamza.malik@vayana.com", "Personal" to "hm73pdpu@gmail.com"),
    mutableMapOf("Work" to "1234567890", "Personal" to "9876543210"),
    mutableMapOf("Office" to "Baroda", "Home" to "Surat"),
    mutableListOf("Office", "Friends"))
    )
  ) as Contact
  println(c2)

  val c3 = addressBookObject.executCommand(
    AddContactCommand(
      AddContactCreateRequest("Bhagvat","Jadaja",
    mutableMapOf("Work" to "bhagvat.jadaja@vayana.com", "Personal" to "bj73pdpu@gmail.com"),
    mutableMapOf("Work" to "1234512345", "Personal" to "9876598765"),
    mutableMapOf("Office" to "Baroda", "Home" to "Rajkot"),
    mutableListOf("Office", "Family"))
    )
  )as Contact
  println(c3)

  val c4 = addressBookObject.executCommand(
    AddContactCommand(
      AddContactCreateRequest("Shivam","Chavda",
    mutableMapOf("Work" to "shivam.chavda@vayana.com", "Personal" to "sc73pdpu@gmail.com"),
    mutableMapOf("Work" to "1234512323", "Personal" to "9876598723"),
    mutableMapOf("Office" to "Baroda", "Home" to "Baroda"),
    mutableListOf("Office", "Friends"))
    )
  )as Contact
  println(c4)

  val updatedC1 = addressBookObject.executCommand(
    UpdateContactCommand(
      UpdateContactRequest( c1.id,"Black","Raval",
    mutableMapOf("Work" to "parth.raval@vayana.com", "Personal" to "pr73pdpu@gmail.com"),
    mutableMapOf("Work" to "7096447878", "Personal" to "7031013939"),
    mutableMapOf("Office" to "Baroda", "Home" to "Bhavnagar"),
    mutableListOf("Office", "Friends", "Family"))
    )
  ) as Contact

  println( "\n" + "-------Updated Contact----------\n" + updatedC1)

  val deleteC3 = addressBookObject.executCommand(DeleteContactCommand(c3.id))
    addressBookObject.listAllContacts()

  println("\n----------Searched Contact---------\n" )
  val foundContacts = addressBookObject.executCommand(SearchContactCommand("Hamza")) as
          List<Contact>
      for (contact in foundContacts){
        println("Contact ID: ${contact.id}")
        println("Name: ${contact.firstName} ${contact.lastName}")
        println("Emails: ${contact.emails}")
        println("Phone Numbers: ${contact.phoneNumber}")
        println("Address: ${contact.address}")
        println("Groups Assosiated: ${contact.groups} \n")

      }

  val Collage = addressBookObject.executCommand(
    AddGroupCommand(
      AddGroupRequest(
    "PDPU Boys",
    mutableListOf(c1,c2,c3)
  )
    )
  ) as Group
  val School = addressBookObject.executCommand(
    AddGroupCommand(
    AddGroupRequest(
    "Vidhiya Dhish",
    mutableListOf(c1,c4)
  )
  )
  ) as Group


  println("\n----------Groups--------\n" )
  val allGroups = addressBookObject.executCommand(ShowGroupsCommand()) as Collection<Group>
  allGroups.forEach{ group ->
    println("Group ID: ${group.Gid}")
    println("Group Name: ${group.groupName}")
    println("Group Members: ${group.groupInfo}")}

  println("\n--------------Updated Group----------------\n")
  val updateGroup = addressBookObject.executCommand(UpdateGroupCommand(UpdateGroupRequest(Collage.Gid, "PDEU Group", mutableListOf(c1,c2,c4))))
  println(updateGroup)

  println("\n------------Updated Group List----------------\n")
  allGroups.forEach{ group ->
    println("Group ID: ${group.Gid}")
    println("Group Name: ${group.groupName}")
    println("Group Members: ${group.groupInfo}")}

  println("\n-----------------Group Deleted----------------\n")
  val deleatedGroup = addressBookObject.executCommand(DeleteGroupContact(School.Gid))
  println(deleatedGroup)

  allGroups.forEach{ group ->
    println("Group ID: ${group.Gid}")
    println("Group Name: ${group.groupName}")
    println("Group Members: ${group.groupInfo}")}

  println("\n----------Searched Group---------\n" )
  val foundGroup = addressBookObject.executCommand(SearchGroupCommand("PDEU Group")) as
          List<Group>
  for (group in foundGroup){
    println("Contact ID: ${group.Gid}")
    println("Group Name: ${group.groupName}")
   println("Group Members: ${group.groupInfo}")
  }

}
