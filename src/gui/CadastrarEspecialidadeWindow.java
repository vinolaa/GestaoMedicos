package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Especialidade;
import service.EspecialidadeService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CadastrarEspecialidadeWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCodigo;

	private EspecialidadeService especialidadeService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEspecialidadeWindow frame = new CadastrarEspecialidadeWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarEspecialidadeWindow() {
		initComponents();
		
		especialidadeService = new EspecialidadeService();
		
		this.limparComponentes();

	}
	
	private void limparComponentes() {

		this.txtNome.setText("");
		this.txtCodigo.setText("");
	}

	private void cadastrarEspecialidade() {

		try {
			Especialidade especialidede = new Especialidade();
			especialidede.setNome(this.txtNome.getText());
			especialidede.setCodigo(Integer.parseInt(this.txtCodigo.getText()));
			System.out.println(especialidede);
			this.especialidadeService.cadastrar(especialidede);
			JOptionPane.showMessageDialog(null, "Especialidade cadastrada.", "Cadastro de especialidade",
					JOptionPane.INFORMATION_MESSAGE);
			this.limparComponentes();
		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar especialidade.", "Cadastro de especialidade",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(20, 69, 49, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(68, 66, 265, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// aqui, enviar código e nome da especialidade para alguma classe da Service
				cadastrarEspecialidade();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(244, 155, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblCadastroDeEspecialidade = new JLabel("Cadastro de Especialidade");
		lblCadastroDeEspecialidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeEspecialidade.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeEspecialidade.setBounds(44, 11, 276, 34);
		contentPane.add(lblCadastroDeEspecialidade);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(20, 155, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblCdigo = new JLabel("Código:");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCdigo.setBounds(20, 100, 49, 14);
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(70, 97, 89, 20);
		contentPane.add(txtCodigo);
	}
}
