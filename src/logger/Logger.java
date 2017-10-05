package logger;

/**
 * @author ${Shreyas MN}
 * 
 */

public class Logger {

	public static enum debugLevels {
		CONSTRUCTOR, RESULT, ERROR
	}

	private static debugLevels level;

	/**
	 * @return the level
	 */
	public static debugLevels getDebugLevel() {
		return level;
	}

	/**
	 * @param debuglevel
	 */
	public static void setDebugLevel(int levelIn) {

		switch (levelIn) {
		
		case 0:
			level = debugLevels.CONSTRUCTOR;
			break;
		case 1:
			level = debugLevels.RESULT;
			break;
		case 2:
			level = debugLevels.ERROR;
			break;
		}
	}

	/**
	 * To Print the output, based on the Debug Level
	 * 
	 */
	public static void writeOutput(debugLevels levelIn, String output) {
		if (levelIn == level)
			System.out.print(output);
	}

	/**
	 * To Print the output, based on the Debug Level
	 * 
	 */
	public static void writeOutput(String output) {
		System.out.print(output);
	}

	/**
	 * @Override toStrinng()
	 * @return String
	 */
	public String toString() {
		return "" + level;
	}
}
