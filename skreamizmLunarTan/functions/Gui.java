package skreamizmLunarTan.functions;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import skreamizmLunarTan.functions.Methods;

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener {
	
	public Gui() {
		initComponents();
	}

	private void button1ActionPerformed(ActionEvent e) {
		switch(comboBox1.getSelectedIndex()) {
			case 0:
				Variables.hideId = Variables.greenhideId;
				Variables.leatherId = Variables.greenleatherId;
				break;
			case 1:
				Variables.hideId = Variables.bluehideId;
				Variables.leatherId = Variables.blueleatherId;
				break;
			case 2:
				Variables.hideId = Variables.redhideId;
				Variables.leatherId = Variables.redleatherId;
				break;
			case 3:
				Variables.hideId = Variables.blackhideId;
				Variables.leatherId = Variables.blackleatherId;
				break;
			case 4:
				Variables.hideId = Variables.royalhideId;
				Variables.leatherId = Variables.royalleatherId;
				break;
		}
		try {
			Variables.hidePrice = Methods.getPrice(Variables.hideId);
			Variables.leatherPrice = Methods.getPrice(Variables.leatherId);
			Variables.astralPrice = Methods.getPrice(Variables.astralRune);
			Variables.bodyPrice = Methods.getPrice(Variables.bodyRune);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		this.setVisible(false);
        this.dispose();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initComponents() {
		label1 = new JLabel();
		comboBox1 = new JComboBox();
		button1 = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Skreamizm Lunar Tanner");
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Select the leather you wish to make:");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label1);
		label1.setBounds(0, 15, 235, 15);

		//---- comboBox1 ----
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {
			"Green dragon leather",
			"Blue dragon leather",
			"Red dragon leather",
			"Black dragon leather",
			"Royal dragon leather"
		}));
		contentPane.add(comboBox1);
		comboBox1.setBounds(40, 40, 155, 30);

		//---- button1 ----
		button1.setText("Start");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button1ActionPerformed(e);
			}
		});
		contentPane.add(button1);
		button1.setBounds(81, 83, 74, 25);
		
		contentPane.setPreferredSize(new Dimension(250, 150));
		setSize(250, 150);
		setLocationRelativeTo(getOwner());
	}

	private JLabel label1;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox1;
	private JButton button1;
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
}

