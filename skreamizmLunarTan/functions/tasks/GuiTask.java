package skreamizmLunarTan.functions.tasks;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.util.Time;

import skreamizmLunarTan.functions.Variables;

public class GuiTask extends Strategy implements Task {

	@Override
	public void run() {
		Variables.status = "Waiting for gui to close...";
		Variables.Gui.setVisible(true);
		while (Variables.Gui.isVisible()) {
			Time.sleep(500);
		}
		Variables.startTime = System.currentTimeMillis();
		Variables.guiOpened = true;	
	}

	@Override
	public boolean validate() {
		return !Variables.guiOpened;
	}
}
