package de.morphyum.owheroselect.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.morphyum.owheroselect.heroes.Hero;
import de.morphyum.owheroselect.heroes.HeroFactory;
import de.morphyum.owheroselect.util.Selector;

import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setTitle("Overwatch Hero Selector v1.1.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Object[] items = { new ImageIcon(this.getClass().getResource("/images/Icon-mccree.png")), new ImageIcon("add16.gif"), new ImageIcon("copy16.gif") };

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
				final JLabel lblNewLabel = new JLabel("Waiting for Select");
				contentPane.add(lblNewLabel, BorderLayout.CENTER);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		

		final JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(15);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy",
				"Pharah", "Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(15);
		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy", "Pharah",
						"Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setMaximumRowCount(15);
		comboBox_2.setModel(
				new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy", "Pharah",
						"Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox_2);
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setMaximumRowCount(15);
		comboBox_3.setModel(
				new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy", "Pharah",
						"Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox_3);

		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setMaximumRowCount(15);
		comboBox_4.setModel(
				new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy", "Pharah",
						"Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox_4);

		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setMaximumRowCount(15);
		comboBox_5.setModel(
				new DefaultComboBoxModel(new String[] { "", "Ana", "Bastion", "D.Va", "Genji", "Hanzo", "Junkrat", "Lucio", "McCree", "Mei", "Mercy", "Pharah",
						"Reaper", "Reinhardt", "Roadhog", "Soldier", "Symmetra", "Torbjörn", "Tracer", "Widowmaker", "Winston", "Zarya", "Zenyatta" }));
		panel.add(comboBox_5);

		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_1.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_2.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		comboBox_3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_3.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		comboBox_4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_4.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		comboBox_5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox_5.getSelectedItem() != null)
					startSelection(comboBox, comboBox_1, comboBox_2, comboBox_3, comboBox_4, comboBox_5, lblNewLabel);
			}
		});
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
				JToggleButton tglbtnResetTeam = new JToggleButton("Reset Team");
				tglbtnResetTeam.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						comboBox.setSelectedItem(comboBox.getItemAt(0));
						comboBox_1.setSelectedItem(comboBox_1.getItemAt(0));
						comboBox_2.setSelectedItem(comboBox_2.getItemAt(0));
						comboBox_3.setSelectedItem(comboBox_3.getItemAt(0));
						comboBox_4.setSelectedItem(comboBox_4.getItemAt(0));
						comboBox_5.setSelectedItem(comboBox_5.getItemAt(0));
						lblNewLabel.setText("Team Reset!");
					}
				});
				panel_1.add(tglbtnResetTeam, BorderLayout.CENTER);
				
				JButton btnRandom = new JButton("Random");
				btnRandom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Random rand = new Random();
						int randomhero = rand.nextInt(21)+1;
						comboBox.setSelectedItem(comboBox.getItemAt(randomhero));
						randomhero = rand.nextInt(22)+1;
						comboBox_1.setSelectedItem(comboBox_1.getItemAt(randomhero));
						randomhero = rand.nextInt(22)+1;
						comboBox_2.setSelectedItem(comboBox_2.getItemAt(randomhero));
						randomhero = rand.nextInt(22)+1;
						comboBox_3.setSelectedItem(comboBox_3.getItemAt(randomhero));
						randomhero = rand.nextInt(22)+1;
						comboBox_4.setSelectedItem(comboBox_4.getItemAt(randomhero));
						randomhero = rand.nextInt(22)+1;
						comboBox_5.setSelectedItem(comboBox_5.getItemAt(randomhero));
						lblNewLabel.setText("Team Randomized!");
					}
				});
				panel_1.add(btnRandom, BorderLayout.WEST);
				
				JButton btnNewButton = new JButton("Auto Team");
				panel_1.add(btnNewButton, BorderLayout.EAST);
				tglbtnResetTeam.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lblNewLabel.setText("Function not yet implemented!");
					}
				});
	}

	private void startSelection(JComboBox comboBox, JComboBox comboBox_1, JComboBox comboBox_2, JComboBox comboBox_3, JComboBox comboBox_4,
			JComboBox comboBox_5, JLabel lblNewLabel) {
		List<String> heroes = Selector.pickHero(comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(),
				comboBox_2.getSelectedItem().toString(), comboBox_3.getSelectedItem().toString(), comboBox_4.getSelectedItem().toString(),
				comboBox_5.getSelectedItem().toString());
		String output = "";
		for (String hero : heroes) {
			output = output + hero + " ";
		}
		lblNewLabel.setText("<html>" + output + "</html>");

	}

}
