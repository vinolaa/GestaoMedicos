package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicialWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialWindow frame = new TelaInicialWindow();
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
	public TelaInicialWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarPacienteWindow janelaCadastroPaciente = new CadastrarPacienteWindow();
				janelaCadastroPaciente.setVisible(true);
				dispose();
			}
		});
		btnCadastrarPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarPaciente.setBounds(107, 74, 179, 23);
		contentPane.add(btnCadastrarPaciente);
		
		JButton btnCadastrarMedico = new JButton("Cadastrar Médico");
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMedicoWindow janelaCadastroMedico = new CadastrarMedicoWindow();
				janelaCadastroMedico.setVisible(true);
				dispose();
			}
		});
		btnCadastrarMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarMedico.setBounds(107, 122, 179, 23);
		contentPane.add(btnCadastrarMedico);
		
		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarConsultaWindow janelaAgendarConsulta = new AgendarConsultaWindow();
				janelaAgendarConsulta.setVisible(true);
				dispose();
			}
		});
		btnAgendarConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendarConsulta.setBounds(107, 170, 179, 23);
		contentPane.add(btnAgendarConsulta);
		
		JButton btnVerificarExames = new JButton("Verificar Exames");
		btnVerificarExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				VerificarExamesWindow janelaVerificarExames = new VerificarExamesWindow();
//				janelaVerificarExames.setVisible(true);
				dispose();
			}
		});
		btnVerificarExames.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificarExames.setBounds(107, 216, 179, 23);
		contentPane.add(btnVerificarExames);
		
		JLabel lblTitulo = new JLabel("Gestão de Médicos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(130, 21, 147, 14);
		contentPane.add(lblTitulo);
	}

}
