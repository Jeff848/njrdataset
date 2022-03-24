package sjm.examples.book.robot;

/**
 * Just for demonstration.
 */
public class PlaceCommand extends RobotCommand {
	/**
	 * Return a textual description of this object.
	 * 
	 * @return a textual description of this object
	 */
	public String toString() {
		return "place " + location;
	}
}
