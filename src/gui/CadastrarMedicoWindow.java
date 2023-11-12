package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarMedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;
	private JTextField txtTelefone;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMedicoWindow frame = new CadastrarMedicoWindow();
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
	public CadastrarMedicoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 63, 49, 14);
		contentPane.add(lblNome);
		
		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCrm.setBounds(10, 100, 49, 14);
		contentPane.add(lblCrm);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco.setBounds(10, 138, 69, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(162, 100, 69, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblEndereco_1_1 = new JLabel("Especialidade:");
		lblEndereco_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco_1_1.setBounds(10, 177, 95, 14);
		contentPane.add(lblEndereco_1_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(56, 60, 312, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(45, 97, 96, 20);
		contentPane.add(txtCRM);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(222, 97, 146, 20);
		contentPane.add(txtTelefone);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(75, 135, 293, 20);
		contentPane.add(txtEndereco);
		
		JComboBox cbEspecialidade = new JComboBox();
		cbEspecialidade.setBounds(104, 173, 264, 22);
		contentPane.add(cbEspecialidade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(279, 218, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCadastroDeMdico = new JLabel("Cadastro do Médico");
		lblCadastroDeMdico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeMdico.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeMdico.setBounds(111, 11, 189, 34);
		contentPane.add(lblCadastroDeMdico);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 218, 89, 23);
		contentPane.add(btnVoltar);
	}
}
