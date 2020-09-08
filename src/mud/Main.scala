package mud

import scala.io.StdIn._
/**
This is a stub for the main class for your MUD.
*/
object Main {
	def main(args: Array[String]): Unit = {
		var _players: List[Player] = Nil
		var inv: List[Item] = Nil
		println("Welcome to my MUD. What is your name?")
		val name = readLine().trim()
		val currentRoom = Room[1]
		println(s"Hello $name.")
		new Player (name, inv, currentRoom)

		while (readLine().trim!= "exit") {
			player.processCommand()
		}
	println("Goodbye!")
	}

}
