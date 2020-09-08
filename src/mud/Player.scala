package mud
import io.StdIn._

class Player (name: String, inv: List[Item], currentRoom: Room) {
    val currentRoom = room.description()
    val _dropItem = room.dropItem()
    val _getItem = room.getItem()
    def processCommand(command: String): Unit = {
        val coms = input.trim.split(" +", 2)
        coms(0).toLowercase match {
        case "n" | "north" => north()
        case "e" | "east" => east()
        case "w" | "west" => west()
        case "s" | "south" => south()
        case "help" => help(command)
        case "inv" | "inventory" => inventoryListing()
        case "look" => currentRoom
        case "drop" => getFromInventory && _dropItem 
        case "get" => addToInventory && _getItem 
        case _ => println("Not a valid command. Please type again\n")
        }
    }
    
    def help(command: String): String = {
        println("n or north = move your player north\n")
        println("s or south = move your player south\n")
        println("w or west = move your player west\n")
        println("e or east = move your player east\n")
        println("help = prints all of the commands and what they do\n")
        println("look = reprints the description of the current room\n")
        println("inv or inventory = list the contents of your inventory\n")
        println("get [Itemname] = to get an item from the room and add it to your inventory\n")
        println("drop [Itemname] = to drop an item from your inventory into the room\n")
        println("exit = leave the game")
    }

    def getFromInventory(itemName: String): Option = {
        items.find(_.name == itemName)
        require() match {
        case Some(item) => 
          Some(item)
          inv -= item
        case None => None
    }
    def addToInventory(item: Item): Unit = {
        items.find(_.name == itemName)
        if (inv != itemName) inv +=item
        else None
    }
    def inventoryListing(): String = {
        val inv = inv.split(" - ")
        println("Inventory: \n")
        println(inv)
    }
    def north(command: String): Room = {
        require(Some(getExit))
        if (Room(exits[0]) == 1) Room
        else None

    }
    def south(command: String): Room = {
        if (Room(exits[1]) == 1) Room
        else None
    }
    def east(command: String): Room = {
        if (Room(exits[2]) == 1) Room
        else None
    }
    def west(command: String): Room = {
        if (Room(exits[3]) == 1) Room
        else None
    }
}
}