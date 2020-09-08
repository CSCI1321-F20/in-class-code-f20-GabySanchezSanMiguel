package mud

import scala.io.Source
 
class Room(name: String, description: String, private var items: List[Item], exits: Array[Option[Int]]) {
  def description(): String = {
    val itemName = items(Item(name))
    println(s"$name")
    println(s"$desc")
    println(s"Exits: $exitCommands")
    println(s"Items: $itemName")
    }
    def exitCommands(Array: Int): String = {
      if (exits[0] == 1) println("North")
      else if (exits[1] == 1) println("South")
      else if (exits[2] == 1) println("East")
      else if (exits[3] == 1) println("West")
      else if(exits[4] == 1) println("Up")
      else (exits[5] == 1) println("Down")
    }
    def getExit(dir: Int): Option[Room] = {
      if (exits(dir) == -1) None0
      else Some(Room.rooms(exits(dir)))
     
    }
    def getItem(itemName: String): Option[Item] = {
      items.find(_.name == itemName) match {
        case Some(item) => 
          items = Room-= items
          Some(item)
        case None => None
      }
    }

    def dropItem(items: Item): Unit = {
      items.find(_.name == itemName)
      require(inv(Item)) 
      if (Room(item) == Nil) Room += items
      else None
    }
  
object Room {
  val rooms = readRooms()
  def readRooms(): Array[Room] = {
    val source = Source.fromFile("map.txt")
    val lines = Source.getLines()
    val r = Array.fill(lines.next().toInt)(readRoom(lines))
    source.close()
    r
  }
    def readRoom(lines: Iterator[String]): Room = {
      val name = lines.next
      val desc = lines.next
      val items = List.fill(lines.next().toInt)(Item(lines.next(), lines.next()))
      val exits = lines.next().split(",").map(_.toInt)
      new Room(name, desc, items, exits)
  }
}
}