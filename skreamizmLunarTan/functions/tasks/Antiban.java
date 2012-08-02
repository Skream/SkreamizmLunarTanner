package skreamizmLunarTan.functions.tasks;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

import skreamizmLunarTan.functions.Variables;

public class Antiban extends Strategy implements Task {

	@Override
	public void run() {
		switch(Random.nextInt(0, 8)){
		case 0:
			Variables.status = "Moving Camera";
			Camera.setAngle(Random.nextInt(-360, 180));
			break;
		case 1:
			Variables.status = "Moving Camera";
			Camera.setAngle(Random.nextInt(1, 120));
			break;
		case 2:
			Variables.status = "Moving Mouse";
			Mouse.move(Random.nextInt(1,500), Random.nextInt(1,500));
			break;
		case 3:
			Variables.status = "Moving Camera";
			Camera.setAngle(Random.nextInt(1, 360));
			break;
		case 4:
			Variables.status = "Moving Mouse";
			Mouse.move(Random.nextInt(1,500), Random.nextInt(1,500));
			break;
		case 5:
			Variables.status = "Toggling Xp Counter";
			Widgets.get(548, 17).click(true);
			break;
		case 6:
			Variables.status = "Checking Stats";
			Tabs.STATS.open();
            Time.sleep(Random.nextInt(500, 1500));
            Tabs.INVENTORY.open();
            break;
		case 7:
			Variables.status = "Checking Xp";
			Tabs.STATS.open();
			Widgets.get(Skills.WIDGET, Skills.WIDGET_MAGIC).hover();
            Time.sleep(Random.nextInt(500, 1500));
            Tabs.INVENTORY.open();
		case 8:
			Variables.status = "Checking Friends";
			Tabs.FRIENDS.open();
            Time.sleep(Random.nextInt(500, 1500));
            Tabs.INVENTORY.open();
            break;
		}
	}
	
	@Override
	public boolean validate() {
		return Random.nextInt(0, 500) == 0 && !Bank.isOpen() && Game.isLoggedIn();
	}
}

