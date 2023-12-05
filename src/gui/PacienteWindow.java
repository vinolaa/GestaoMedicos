package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PacienteWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PacienteWindow frame = new PacienteWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PacienteWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente");
		lblPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaciente.setFont(new Font("Arial", Font.BOLD, 18));
		lblPaciente.setBounds(127, 11, 101, 29);
		contentPane.add(lblPaciente);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				janelaTelaInicial.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 181, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarConsultaWindow janelaAgendarConsulta = new AgendarConsultaWindow();
				janelaAgendarConsulta.setVisible(true);
				janelaAgendarConsulta.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgendarConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendarConsulta.setBounds(192, 94, 150, 23);
		contentPane.add(btnAgendarConsulta);
		
		JButton btnVerificarExames = new JButton("Agendar Exames");
		btnVerificarExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarExamesWindow janelaVerificarExames = new AgendarExamesWindow();
				janelaVerificarExames.setVisible(true);
				janelaVerificarExames.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVerificarExames.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificarExames.setBounds(10, 94, 150, 23);
		contentPane.add(btnVerificarExames);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarPacienteWindow janelaCadastroPaciente = new CadastrarPacienteWindow();
				janelaCadastroPaciente.setVisible(true);
				janelaCadastroPaciente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCadastrarPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarPaciente.setBounds(10, 51, 150, 23);
		contentPane.add(btnCadastrarPaciente);
		
		JButton btnExames = new JButton("Consultas");
		btnExames.setFont(new Font("Arial", Font.PLAIN, 12));
		btnExames.setBounds(192, 135, 150, 23);
		contentPane.add(btnExames);
		
		JButton btnConsultas = new JButton("Exames");
		btnConsultas.setFont(new Font("Arial", Font.PLAIN, 12));
		btnConsultas.setBounds(10, 135, 150, 23);
		contentPane.add(btnConsultas);
	}
}
