import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")

public class ProgFrame extends JFrame {

	private JPanel contentPane;
	static Button RESET;
	static Button StepButton;
	static Button ExButton;
	static int C = 0;
	static RAM ram;
	static CPU cpu;
	static ROM rom;
	static JTextArea textArea;
	static JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgFrame frame = new ProgFrame(null, null, null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	static String TEXT = new String();
	/**
	 * Create the frame.
	 */
	public ProgFrame(Programme P, CPU a, RAM b, ROM c) {
		
		cpu = a;
		ram = b;
		rom = c;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(275, 138, 214, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 180, 225);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 235, 180, 21);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(0, 0, 180, 21);
		panel.add(lblNewLabel);
		
		ExButton = new Button("Assembler");
		ExButton.setFocusable(false);
		ExButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EXEC();
				
			}
		});
		ExButton.setBounds(116, 262, 74, 21);
		contentPane.add(ExButton);
		
		StepButton = new Button("Step by Step");
		StepButton.setEnabled(false);
		StepButton.setBounds(10, 262, 74, 21);
		contentPane.add(StepButton);
		StepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Step();
			}
		});
		
		RESET = new Button("R");
		RESET.setEnabled(false);
		RESET.setBounds(90, 262, 21, 21);
		contentPane.add(RESET);
		RESET.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
	}
	
	static void Reset() {
		RESET.setEnabled(false);
		StepButton.setEnabled(false);
		ExButton.setEnabled(true);
		C=0;
		cpu.reset();
		ram.reset();
		rom.reset();
		Programme.CPUUP();
		Programme.RAMUP();
		Programme.ROMUP();
		textArea.setEditable(true);
		lblNewLabel.setText("");

	}
	
	static void Step() {
		TEXT = textArea.getText().toUpperCase();
		String[] Tab1 = TEXT.split("\\n");
		if(Tab1[C].trim().matches("END"))
		{
			StepButton.setEnabled(false);
		}
		else {
			Programme.Execute(TEXT,C);
			C++;
		}
	}
	
	static boolean Syn() {
		if(Programme.Syntax(TEXT))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	static void EXEC() {
		TEXT = textArea.getText().toUpperCase();
		if(Programme.Syntax(TEXT)) {
			RESET.setEnabled(true);
			StepButton.setEnabled(true);
			ExButton.setEnabled(false);
			lblNewLabel.setText("Syntax CORRECT");
			lblNewLabel.setForeground(new Color(50,205,50));
			textArea.setEditable(false);
		}
		else
		{
			lblNewLabel.setText("Syntax ERROR");
			lblNewLabel.setForeground(new Color(255, 0, 0));
		}
	}
	
	static void clearTXT() {
		textArea.setText("");
	}
}
