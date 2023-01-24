//interface Command {
//    fun execute(currentValue: Int): Int
//    fun undo(currentValue: Int): Int
//}
//class AddCommand(
//    private val valueToAdd: Int
//):Command {
//    override fun execute(currentValue: Int): Int {
//        return currentValue + valueToAdd
//    }
//
//    override fun undo(currentValue: Int): Int {
//        return currentValue - valueToAdd
//    }
//}
//class subtractCommand(
//    private val valueToSubtract: Int
//): Command {
//    override fun execute(currentValue: Int): Int {
//        return currentValue - valueToSubtract
//    }
//
//    override fun undo(currentValue: Int): Int {
//        return currentValue + valueToSubtract
//    }
//}
//class multiplyCommand(
//    private val valueToMultiply: Int
//): Command {
//    override fun execute(currentValue: Int): Int {
//        return currentValue * valueToMultiply
//    }
//
//    override fun undo(currentValue: Int): Int {
//        return currentValue / valueToMultiply
//    }
//}
//class DivideCommand(
//    private val valueToDivide: Int
//): Command {
//    override fun execute(currentValue: Int): Int {
//        return currentValue / valueToDivide
//    }
//    override fun undo(currentValue: Int): Int {
//        return currentValue * valueToDivide
//    }
//}
//class AddAndMultiplyCommand(
//    private val valueToAdd: Int,
//    private val valueToMultiply: Int
//): Command {
//    override fun execute(currentValue: Int): Int {
//        val addedValue = AddCommand(valueToAdd).execute(currentValue)
//        return multiplyCommand(valueToMultiply).execute(addedValue)
//    }
//    ​
//    override fun undo(currentValue: Int): Int {
//        TODO("Not yet implemented")
//    }
//    ​
//}
//
//class Calculator(
//    private var value: Int = 0,
//    val history: MutableList<Command> = mutableListOf()
//) {
//    fun executeCommand(command: Command): Int {
//        value = command.execute(value)
//        history.add(command)
//        return value
//    }
//    ​
//    fun undoCommand(command: Command): Int {
//        value = command.undo(value)
//        history.add(command)
//        return value
//    }
//}
//​
//fun main() {
//    ​
//    val calc = Calculator()
//    ​
////    println(calc.executeCommand(AddCommand(10)))
////    val addCmd = AddCommand(20)
////    println(calc.executeCommand(addCmd))
////    println(calc.undoCommand(addCmd))
////    println(calc.history)
////
////
////    val subtractCmd = SubtractCommand(3)
////    println(calc.executeCommand(subtractCmd))
//    ​
//    println(calc.executeCommand(AddAndMultiplyCommand(5, 3)))
//}
