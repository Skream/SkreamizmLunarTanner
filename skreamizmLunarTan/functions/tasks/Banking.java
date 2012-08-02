package skreamizmLunarTan.functions.tasks;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import skreamizmLunarTan.functions.Variables;

public class Banking extends Strategy implements Task {

	@Override
	public void run() {
		Variables.status = "Opening Bank";
		if (!Bank.isOpen()) {
			Bank.open();
		}
		if (Bank.isOpen()) {
			Variables.status = "Banking";
			Bank.deposit(Variables.leatherId, 0);
			if (Inventory.getCount(Variables.hideId) < 5) {
				Bank.withdraw(Variables.hideId, 0);
			}
			if (Inventory.getCount(Variables.hideId) > 4) {
				Bank.close();
			} else {
				return;
			}
		}	
	}
	
	@Override
	public boolean validate() {
		return Inventory.getCount(Variables.hideId) < 5 || Bank.isOpen();
	}
}
