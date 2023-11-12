package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarPacienteWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField texNome;
	private JTextField txtEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPacienteWindow frame = new CadastrarPacienteWindow();
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
	public CadastrarPacienteWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDePaciente = new JLabel("Cadastro de Paciente");
		lblCadastroDePaciente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDePaciente.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDePaciente.setBounds(110, 11, 189, 34);
		contentPane.add(lblCadastroDePaciente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 59, 49, 14);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblEndereco.setBounds(10, 210, 69, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTelefone.setBounds(162, 96, 69, 14);
		contentPane.add(lblTelefone);
		
		texNome = new JTextField();
		texNome.setColumns(10);
		texNome.setBounds(56, 56, 312, 20);
		contentPane.add(texNome);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(75, 210, 293, 20);
		contentPane.add(txtEndereco);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(279, 245, 89, 23);
		contentPane.add(btnCadastrar);
		
		JPanel painelAlunos = new JPanel();
		painelAlunos.setLayout(null);
		painelAlunos.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144), 1, true), "Sexo",

						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelAlunos.setBounds(8, 84, 140, 106);
		contentPane.add(painelAlunos);
		
		JRadioButton rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setFont(new Font("Arial", Font.PLAIN, 12));
		rbMasculino.setBounds(23, 19, 111, 23);
		painelAlunos.add(rbMasculino);
		
		JRadioButton rbFminino = new JRadioButton("Feminino");
		rbFminino.setFont(new Font("Arial", Font.PLAIN, 12));
		rbFminino.setBounds(23, 45, 111, 23);
		painelAlunos.add(rbFminino);
		
		JRadioButton rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setFont(new Font("Arial", Font.PLAIN, 12));
		rbNaoInformar.setBounds(23, 75, 111, 23);
		painelAlunos.add(rbNaoInformar);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(162, 135, 122, 18);
		contentPane.add(lblDataDeNascimento);
		
		JFormattedTextField txtDataNascimento = new JFormattedTextField((AbstractFormatter) null);
		txtDataNascimento.setBounds(286, 135, 80, 20);
		contentPane.add(txtDataNascimento);
		
		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPagamento.setBounds(162, 170, 69, 18);
		contentPane.add(lblPagamento);
		
		JComboBox cbPagamento = new JComboBox();
		cbPagamento.setBounds(234, 170, 134, 18);
		contentPane.add(cbPagamento);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 245, 89, 23);
		contentPane.add(btnVoltar);
		
		JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(222, 93, 146, 20);
		contentPane.add(txtTelefone);
	}
}
