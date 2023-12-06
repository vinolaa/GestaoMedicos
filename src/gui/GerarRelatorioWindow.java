package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.ExameAgendadoService;

public class GerarRelatorioWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarRelatorioWindow frame = new GerarRelatorioWindow();
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
	public GerarRelatorioWindow() {
		
		this.initComponents();
	}
	
	public void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAgendaMedico = new JButton("Agenda Médico");
		btnAgendaMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgendaMedicoWindow janelaAgendaMecido = new AgendaMedicoWindow();
				janelaAgendaMecido.setVisible(true);
				janelaAgendaMecido.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		contentPane.setLayout(null);

		btnAgendaMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendaMedico.setBounds(137, 36, 139, 23);
		contentPane.add(btnAgendaMedico);

		setContentPane(contentPane);
		
		JButton btnAgendaExame = new JButton("Agenda Exame");
		btnAgendaExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HistoricoExamesWindow janelaAgendaExames = new HistoricoExamesWindow();
				janelaAgendaExames.setVisible(true);
				janelaAgendaExames.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgendaExame.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendaExame.setBounds(148, 101, 117, 23);
		contentPane.add(btnAgendaExame);
		
		JButton btnAgendaPaciente = new JButton("Agenda Paciente");
		btnAgendaPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HistoricoPacienteWindow janelaAgendaPaciente = new HistoricoPacienteWindow();
				janelaAgendaPaciente.setVisible(true);
				janelaAgendaPaciente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgendaPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendaPaciente.setBounds(148, 182, 139, 23);
		contentPane.add(btnAgendaPaciente);
	}
}
