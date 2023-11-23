package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendaMedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAgenda;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaMedicoWindow frame = new AgendaMedicoWindow();
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
	public AgendaMedicoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel painelAlunos = new JPanel();
		painelAlunos.setLayout(null);
		painelAlunos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agenda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelAlunos.setBounds(10, 60, 465, 269);
		contentPane.add(painelAlunos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 446, 235);
		painelAlunos.add(scrollPane);
		
		tblAgenda = new JTable();
		tblAgenda.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Exame", "Paciente", "Valor"
			}
		));
		scrollPane.setViewportView(tblAgenda);
		
		textField = new JTextField();
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(45, 11, 96, 20);
		contentPane.add(textField);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCrm.setBounds(10, 14, 40, 14);
		contentPane.add(lblCrm);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(255, 10, 100, 23);
		contentPane.add(btnBuscar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoWindow janelaMedico = new MedicoWindow();
				janelaMedico.setVisible(true);
				janelaMedico.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(373, 10, 100, 23);
		contentPane.add(btnVoltar);
	}
}
