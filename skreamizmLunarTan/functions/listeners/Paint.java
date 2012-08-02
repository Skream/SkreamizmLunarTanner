package skreamizmLunarTan.functions.listeners;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.NumberFormat;

import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Time;

import skreamizmLunarTan.functions.Variables;

public class Paint {
	
	public static void onRepaint(Graphics g) {
		Variables.runTime = System.currentTimeMillis() - Variables.startTime;
		Variables.time = Time.format(Variables.runTime);
		
		Variables.expGained = Skills.getExperience(Skills.MAGIC) - Variables.startExp;
		Variables.expToLvl = Skills.getExperienceToLevel(Skills.MAGIC, Skills.getLevel(Skills.MAGIC) + 1);
		Variables.profit = (int)Math.floor((Variables.leatherPrice * Variables.tanned) - ((Variables.hidePrice * Variables.tanned) + ((0.4 * Variables.astralPrice) + (0.4 * Variables.bodyPrice)) * Variables.tanned));
		
		Variables.expPerHour = (int)Math.floor((Variables.expGained * 3600000D) / (System.currentTimeMillis() - Variables.startTime));
		Variables.tannedPerHour = (int)Math.floor((Variables.tanned * 3600000D) / (System.currentTimeMillis() - Variables.startTime));
		Variables.profitPerHour = (int)Math.floor((Variables.profit * 3600000D) / (System.currentTimeMillis() - Variables.startTime));
		
		NumberFormat nf = NumberFormat.getInstance();
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(Variables.Banner, 0, 0, null);
		g2.drawString("Runtime: " + Variables.time, 30, 13);
		g2.drawString("Current Level: " + Skills.getLevel(Skills.MAGIC) + " (" + (Skills.getLevel(Skills.MAGIC) - Variables.startLvl) + ")", 30, 26);
		g2.drawString("Exp to level: " + nf.format(Variables.expToLvl), 595, 39);
		g2.drawString("Exp Gained: " + nf.format(Variables.expGained) + " (" + nf.format(Variables.expPerHour) + "/Hr)", 30, 39);
		g2.drawString("Hides Tanned: " + nf.format(Variables.tanned) + " (" + nf.format(Variables.tannedPerHour) + "/Hr)", 595, 13);
		g2.drawString("Profit: " + nf.format(Variables.profit) + " (" + nf.format(Variables.profitPerHour) + "/Hr)", 595, 26);
		g2.drawString("" + Variables.status, 7, 385);
		try {
			if (Variables.expPerHour > 0) {
				long msTNL = ((Variables.expToLvl) / (Variables.expPerHour / 3600) * 1000);
				String TTNL = Time.format(msTNL);
				g.drawString("Next level in: " + TTNL, 396, 385);
			} else {
				g.drawString("Next level in: 00:00:00", 396, 385);
			}
		} catch (Exception e) {
			g.drawString("Next level in: -1:-1:-1", 396, 385);
		}
		g2.setColor(Color.YELLOW);
		g2.drawLine(Mouse.getX() - 6, Mouse.getY() - 6, Mouse.getX() - 3 , Mouse.getY() - 3);
		g2.drawLine(Mouse.getX() + 6, Mouse.getY() + 6, Mouse.getX() + 3 , Mouse.getY() + 3);
		g2.drawLine(Mouse.getX() - 6, Mouse.getY() + 6, Mouse.getX() - 3 , Mouse.getY() + 3);
		g2.drawLine(Mouse.getX() + 6, Mouse.getY() - 6, Mouse.getX() + 3 , Mouse.getY() - 3);
		g2.setColor(Mouse.isPressed() ? Color.RED : Color.BLACK);	
		g2.drawLine(Mouse.getX(), Mouse.getY() - 3, Mouse.getX(), Mouse.getY() + 3);
		g2.drawLine(Mouse.getX() - 3, Mouse.getY(), Mouse.getX() + 3, Mouse.getY());
	}
}
