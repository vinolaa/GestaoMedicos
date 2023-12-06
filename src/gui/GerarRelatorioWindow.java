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
		setBounds(100, 100, 198, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnAgendaMedico = new JButton("Voltar");
		btnAgendaMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				janelaTelaInicial.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		contentPane.setLayout(null);

		btnAgendaMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendaMedico.setBounds(26, 132, 130, 23);
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
		btnAgendaExame.setBounds(26, 37, 130, 23);
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
		btnAgendaPaciente.setBounds(26, 86, 130, 23);
		contentPane.add(btnAgendaPaciente);
	}
}
