package skreamizmLunarTan.functions.tasks;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Settings;
import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import skreamizmLunarTan.functions.Variables;



public class Cast extends Strategy implements Task {

	int x = Settings.get(1801);
	int initialx = x;
	
	@Override
	public void run() {
		if (Tabs.getCurrent() != Tabs.MAGIC) {
			Variables.status = "Opening magic tab";
			Tabs.MAGIC.open();
		}
		Variables.status = "Casting spell";
		Widgets.get(Variables.spellParent, Variables.spellChild).click(true);
		Inventory.getItem(Variables.hideId).getWidgetChild().interact("Cast");
		Mouse.move(Random.nextInt(205, 310), Random.nextInt(450, 505));
		for (int i = 0; i < 20; i++) {
			if (Widgets.get(Variables.tanParent).validate()) {
				Mouse.click(true);
				Variables.status = "Tanning hides";
				break;
			} else {
				Time.sleep(100);
			}
		}
		for (int i = 0; i < 60 && Inventory.getCount(Variables.hideId) > 4; i++) {
			Time.sleep(200);
			x = Settings.get(1801);
			if (x != initialx) {
				Variables.tanned = Variables.tanned + 5;
				initialx = x;
			}
		}
		Bank.getNearest().hover();
		while (Players.getLocal().getAnimation() == 7756) {
			Time.sleep(100);
		}
	}
	
	@Override
	public boolean validate() {
		return Inventory.getCount(Variables.hideId) > 4 && !Bank.isOpen();
	}
}
