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

public class MedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicoWindow frame = new MedicoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MedicoWindow() {
		
		this.initComponents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 208, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMdico = new JLabel("Médico");
		lblMdico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMdico.setFont(new Font("Arial", Font.BOLD, 18));
		lblMdico.setBounds(40, 11, 101, 29);
		contentPane.add(lblMdico);
		
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
		btnVoltar.setBounds(52, 169, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnCadastrarEspecialidade = new JButton("Cadastrar Especialidade");
		btnCadastrarEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarEspecialidadeWindow janelaCadastroEspecialidade = new CadastrarEspecialidadeWindow();
		        janelaCadastroEspecialidade.setVisible(true);
		        janelaCadastroEspecialidade.setLocationRelativeTo(null);
		        dispose();
			}
		});
		btnCadastrarEspecialidade.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarEspecialidade.setBounds(10, 51, 168, 23);
		contentPane.add(btnCadastrarEspecialidade);
		
		JButton btnCadastrarMedico = new JButton("Cadastrar Médico");
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMedicoWindow janelaCadastroMedico = new CadastrarMedicoWindow();
				janelaCadastroMedico.setVisible(true);
				janelaCadastroMedico.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnCadastrarMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarMedico.setBounds(10, 89, 168, 23);
		contentPane.add(btnCadastrarMedico);
		
		JButton btnAgendaMdico = new JButton("Agenda do Médico");
		btnAgendaMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendaMedicoWindow janelaAgendaMecido = new AgendaMedicoWindow();
				janelaAgendaMecido.setVisible(true);
				janelaAgendaMecido.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAgendaMdico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendaMdico.setBounds(10, 130, 168, 23);
		contentPane.add(btnAgendaMdico);
	}
}
