import addressBookOperation.Command

//package addressBookOperation
//
//import Contact
//
//class AddContact(
//    val contactToAdd: Contact
//):Command {
//    override fun execute(ContactList: MutableList<Contact>): MutableList<Contact> {
//        ContactList.add(contactToAdd)
//        return ContactList
//    }
//
//}
//class DeleteContact(
//    val contactToDelete: Contact
//):Command {
//    override fun execute(ContactList: MutableList<Contact>): MutableList<Contact> {
//        for ((i, ele) in ContactList.withIndex()){
//            if (ele.firstName == contactToDelete.firstName){
//                ContactList.removeAt(i)
//                return ContactList
//            }
//        }
//        return ContactList
//    }
//}
//class SearchContact(
//    val contactToSearch: Contact
//):Command {
//    override fun execute(ContactList: MutableList<Contact>): MutableList<Contact> {
//        val searchedNameList: MutableList<Contact> = mutableListOf()
//        for (contact in ContactList){
//            if(contactToSearch.firstName == contact.firstName){
//                searchedNameList.add(contact)
//            }
//
//        }
//        return searchedNameList
//    }
//
//}
//

//class AddressBook {
//    var commandList : MutableList<Command>() = mutableListOf()
//    fun executCommand(command: Command): MutableList<Command>{
//        commandList.add(command)
//        return command.execute()
//    }
//    fun addContact(contact: Contact) {
//        val addCommand = addContact(contact)
//        addCommand.execute(contactList)
//    }
//    fun deleteContact(contact: Contact){
//        val deleteComand = DeleteContact(contact)
//        deleteComand.execute((contactList))
////      println(contactList)
//    }
//    fun listAllContacts() {
//        (contactList.map { it -> println("${it.firstName} ${it.lastName} ")})
//        println(contactList.joinToString("\n"))
//    }
//}
//
