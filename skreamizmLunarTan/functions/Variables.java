package skreamizmLunarTan.functions;

import java.awt.image.BufferedImage;

public class Variables {

	//Hide Id's
	public static int greenhideId = 1753;
	public static int bluehideId = 1751;
	public static int redhideId = 1749;
	public static int blackhideId = 1747;
	public static int royalhideId = 24372;
	
	//Leather Id's
	public static int greenleatherId = 1745;
	public static int blueleatherId = 2505;
	public static int redleatherId = 2507;
	public static int blackleatherId = 2509;
	public static int royalleatherId = 24374;
	
	//Rune Id's
	public static int astralRune = 9075;
	public static int bodyRune = 559;
	
	//WidgetParent Id's
	public static int tanParent = 905;
	public static int spellParent = 430;

	//WidgetChild Id's
	public static int tanChild = 14;
	public static int spellChild = 72;
		
	//Statistics
	public static int x, startExp, startLvl, expGained, expToLvl, expPerHour, tannedPerHour, profit, profitPerHour, hideId, leatherId, leatherChild, hidePrice, leatherPrice, astralPrice, bodyPrice, tanned;
	public static long startTime, runTime;
	public static String status, time;
	
	//Paint Constants
	public static BufferedImage Banner;
	
	//Booleans
	public static boolean guiOpened = false;
	
	//Gui
	public static Gui Gui = new Gui();
	
	//etc.
	public static int initialX = x;
	
}
