package skreamizmLunarTan;

import java.awt.Graphics;
import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.bot.event.MessageEvent;
import org.powerbot.game.bot.event.listener.MessageListener;
import org.powerbot.game.bot.event.listener.PaintListener;

import skreamizmLunarTan.functions.Variables;
import skreamizmLunarTan.functions.Methods;
import skreamizmLunarTan.functions.listeners.Paint;
import skreamizmLunarTan.functions.tasks.Antiban;
import skreamizmLunarTan.functions.tasks.Banking;
import skreamizmLunarTan.functions.tasks.Cast;
import skreamizmLunarTan.functions.tasks.GuiTask;

@Manifest(authors = { "Skreamizm" }, name = "Skreamizm Lunar Tanner", description = "Tans hides with the lunar magic spell (Start with runes in inventory and fire staff equipped).", version = 1.0)
public class SkreamizmLunarTan extends ActiveScript implements PaintListener, MessageListener {

	@Override
	protected void setup() {
		
		Variables.startExp = Skills.getExperience(Skills.MAGIC);
		Variables.startLvl = Skills.getLevel(Skills.MAGIC);
		
		Methods.getPaint();
		
		provide(new GuiTask());
		provide(new Cast());
		provide(new Banking());
		provide(new Antiban());
		
	}

	@Override
	public void messageReceived(MessageEvent arg0) {
		String msg = arg0.getMessage();
		if (msg.contains("You do not have enough astral") || msg.contains("You do not have enough body") || msg.contains("You do not have enough fire")) {
			log.severe("Please have the required runes already in your inventory!");
			stop();
		}
	}

	@Override
	public void onRepaint(Graphics arg0) {
		Paint.onRepaint(arg0);	
	}

}
