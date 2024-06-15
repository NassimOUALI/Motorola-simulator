import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class CPUFrame extends JFrame {
	
	JTextField RegA;
	JTextField RegB;
	JTextField RegFlag;
	JTextField RegDP;
	JTextField Instruction;
	JTextField RegPC;
	JTextField RegS;
	JTextField RegU;
	JTextField RegY;
	JTextField RegX;
	JLabel lblNewLabel_1_3_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CPUFrame frame = new CPUFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CPUFrame(CPU cpu) {
		getContentPane().setForeground(new Color(43, 43, 43));
		String pwd = System.getProperty("user.dir");
		setIconImage(Toolkit.getDefaultToolkit().getImage(pwd+"/files/icon.png"));
		getContentPane().setBackground(new Color(193, 193, 193));
		setResizable(false);
		setTitle("Architecture interne de MOTO 6809");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(10, 138, 267, 479);
		getContentPane().setLayout(null);
		
		ImageIcon icon = new ImageIcon("./files/UAL.png");
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(101, 147, 148, 188);
		getContentPane().add(lblNewLabel);
		//Made By Nimo:
		RegA = new JTextField();
		RegA.setForeground(new Color(43, 43, 43));
		RegA.setHorizontalAlignment(SwingConstants.LEFT);
		RegA.setText(cpu.A.val);
		RegA.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegA.setEditable(false);
		RegA.setBounds(51, 166, 51, 43);
		getContentPane().add(RegA);
		RegA.setColumns(10);
		
		RegB = new JTextField();
		RegB.setForeground(new Color(43, 43, 43));
		RegB.setText(cpu.B.val);
		RegB.setHorizontalAlignment(SwingConstants.LEFT);
		RegB.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegB.setEditable(false);
		RegB.setColumns(10);
		RegB.setBounds(51, 273, 51, 43);
		getContentPane().add(RegB);
		
		RegFlag = new JTextField();
		RegFlag.setForeground(new Color(43, 43, 43));
		RegFlag.setText(cpu.F.val);
		RegFlag.setHorizontalAlignment(SwingConstants.CENTER);
		RegFlag.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegFlag.setEditable(false);
		RegFlag.setColumns(10);
		RegFlag.setBounds(111, 335, 138, 36);
		getContentPane().add(RegFlag);
		
		RegDP = new JTextField();
		RegDP.setForeground(new Color(43, 43, 43));
		RegDP.setText(cpu.DP.val);
		RegDP.setHorizontalAlignment(SwingConstants.LEFT);
		RegDP.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegDP.setEditable(false);
		RegDP.setColumns(10);
		RegDP.setBounds(51, 335, 51, 36);
		getContentPane().add(RegDP);
		
		JLabel lblNewLabel_1 = new JLabel("DP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1.setBounds(12, 336, 34, 36);
		getContentPane().add(lblNewLabel_1);
		
		Instruction = new JTextField();
		Instruction.setForeground(new Color(43, 43, 43));
		Instruction.setText(cpu.I.val);
		Instruction.setHorizontalAlignment(SwingConstants.LEFT);
		Instruction.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		Instruction.setEditable(false);
		Instruction.setColumns(10);
		Instruction.setBounds(12, 57, 229, 36);
		getContentPane().add(Instruction);
		
		RegPC = new JTextField();
		RegPC.setForeground(new Color(43, 43, 43));
		RegPC.setText(cpu.PC.val);
		RegPC.setHorizontalAlignment(SwingConstants.LEFT);
		RegPC.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegPC.setEditable(false);
		RegPC.setColumns(10);
		RegPC.setBounds(114, 11, 78, 36);
		getContentPane().add(RegPC);
		
		JLabel lblNewLabel_1_1 = new JLabel("PC");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(73, 12, 34, 36);
		getContentPane().add(lblNewLabel_1_1);
		//Made By Nimo:
		JLabel lblNewLabel_1_2 = new JLabel("B");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_2.setBounds(22, 277, 19, 36);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("A");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_3.setBounds(22, 170, 19, 36);
		getContentPane().add(lblNewLabel_1_3);
		
		RegS = new JTextField();
		RegS.setForeground(new Color(43, 43, 43));
		RegS.setText(cpu.S.val);
		RegS.setHorizontalAlignment(SwingConstants.LEFT);
		RegS.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegS.setEditable(false);
		RegS.setColumns(10);
		RegS.setBounds(38, 101, 78, 36);
		getContentPane().add(RegS);
		
		RegU = new JTextField();
		RegU.setForeground(new Color(43, 43, 43));
		RegU.setEditable(false);
		RegU.setText(cpu.U.val);
		RegU.setHorizontalAlignment(SwingConstants.LEFT);
		RegU.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegU.setColumns(10);
		RegU.setBounds(163, 101, 78, 36);
		getContentPane().add(RegU);
		
		RegY = new JTextField();
		RegY.setForeground(new Color(43, 43, 43));
		RegY.setText(cpu.Y.val);
		RegY.setHorizontalAlignment(SwingConstants.LEFT);
		RegY.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegY.setEditable(false);
		RegY.setColumns(10);
		RegY.setBounds(163, 396, 78, 36);
		getContentPane().add(RegY);
		
		RegX = new JTextField();
		RegX.setForeground(new Color(43, 43, 43));
		RegX.setText(cpu.X.val);
		RegX.setHorizontalAlignment(SwingConstants.LEFT);
		RegX.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		RegX.setEditable(false);
		RegX.setColumns(10);
		RegX.setBounds(38, 396, 78, 36);
		getContentPane().add(RegX);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("X");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_3_1.setBounds(12, 397, 19, 36);
		getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Y");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_2.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_3_2.setBounds(141, 397, 19, 36);
		getContentPane().add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("U");
		lblNewLabel_1_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_3.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_3_3.setBounds(141, 103, 19, 36);
		getContentPane().add(lblNewLabel_1_3_3);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("S");
		lblNewLabel_1_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_4.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1_3_4.setBounds(12, 103, 19, 36);
		getContentPane().add(lblNewLabel_1_3_4);
		//Made By Nimo:
		lblNewLabel_1_3_5 = new JLabel("E F H I N Z V C");
		lblNewLabel_1_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3_5.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblNewLabel_1_3_5.setBounds(125, 366, 116, 36);
		getContentPane().add(lblNewLabel_1_3_5);
	}
}
