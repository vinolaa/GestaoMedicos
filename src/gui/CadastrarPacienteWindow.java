package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import entities.Paciente;
import entities.Pagamento;
import service.PacienteService;
import service.PagamentoService;

import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastrarPacienteWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JFormattedTextField txtTelefone;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraTelefone;
	private JComboBox<Pagamento> cbPagamento;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JRadioButton rbNaoInformar;
	private JFormattedTextField txtDataNascimento;
	private JPanel painelAlunos;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private PacienteService pacienteService;
	private PagamentoService pagamentoService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarPacienteWindow frame = new CadastrarPacienteWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarPacienteWindow() {
		criarMascaraData();
		criarMascaraTelefone();
		initComponents();

		pacienteService = new PacienteService();
		pagamentoService = new PagamentoService();

		this.buscarPagamentos();
		this.limparComponentes();

	}

	private void limparComponentes() {

		this.txtNome.setText("");
		this.rbNaoInformar.setSelected(true);
		this.cbPagamento.setSelectedIndex(0);
		this.txtTelefone.setText("");
		this.txtDataNascimento.setText("");
		this.txtEndereco.setText("");
	}

	private void buscarPagamentos() {

		try {

			List<Pagamento> pagamentos = this.pagamentoService.buscarTodos();

			for (Pagamento pagamento : pagamentos) {
				this.cbPagamento.addItem(pagamento);
			}

		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao buscar os dados dos pagamentos.", "Busca de Pagamento",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void criarMascaraData() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private void criarMascaraTelefone() {
		try {
			this.mascaraTelefone = new MaskFormatter("#####-####");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	private String verificarSelecaoRadioButtonSexo() {

		if (this.rbMasculino.isSelected()) {
			return this.rbMasculino.getText();
		} else if (this.rbFeminino.isSelected()) {
			return this.rbFeminino.getText();
		} else {
			return this.rbNaoInformar.getText();
		}
	}

	public void cadastrarPaciente() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Paciente paciente = new Paciente();

			paciente.setNome(this.txtNome.getText());
			paciente.setEndereco(this.txtEndereco.getText());
			paciente.setTelefone(this.txtTelefone.getText());
			paciente.setFoto("Foto");
			paciente.setDataNascimento(new java.sql.Date(sdf.parse(this.txtDataNascimento.getText()).getTime()));
			paciente.setSexo(verificarSelecaoRadioButtonSexo());
			Pagamento pagamento = (Pagamento) this.cbPagamento.getSelectedItem();
			paciente.setFormaPagamento(pagamento.getCodigo());
			this.pacienteService.cadastrar(paciente);
			JOptionPane.showMessageDialog(null, "Paciente cadastrado.", "Cadastro de paciente",
					JOptionPane.INFORMATION_MESSAGE);
			this.limparComponentes();
		} catch (SQLException | IOException | ParseException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente.", "Cadastro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void initComponents() {
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

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(56, 56, 312, 20);
		contentPane.add(txtNome);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(75, 210, 293, 20);
		contentPane.add(txtEndereco);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPaciente();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(279, 245, 89, 23);
		contentPane.add(btnCadastrar);

		painelAlunos = new JPanel();
		painelAlunos.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelAlunos.setBounds(8, 84, 140, 106);
		contentPane.add(painelAlunos);
		painelAlunos.setLayout(null);

		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.setFont(new Font("Arial", Font.PLAIN, 12));
		rbMasculino.setBounds(23, 19, 111, 23);
		buttonGroup.add(rbMasculino);
		painelAlunos.add(rbMasculino);

		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.setFont(new Font("Arial", Font.PLAIN, 12));
		rbFeminino.setBounds(23, 48, 111, 23);
		buttonGroup.add(rbFeminino);
		painelAlunos.add(rbFeminino);

		rbNaoInformar = new JRadioButton("Não Informar");
		rbNaoInformar.setFont(new Font("Arial", Font.PLAIN, 12));
		rbNaoInformar.setBounds(23, 75, 111, 23);
		buttonGroup.add(rbNaoInformar);
		painelAlunos.add(rbNaoInformar);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(162, 135, 122, 18);
		contentPane.add(lblDataDeNascimento);

		txtDataNascimento = new JFormattedTextField(mascaraData);
		txtDataNascimento.setBounds(286, 135, 80, 20);
		contentPane.add(txtDataNascimento);

		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPagamento.setBounds(162, 170, 69, 18);
		contentPane.add(lblPagamento);

		cbPagamento = new JComboBox<Pagamento>();
		cbPagamento.setBounds(234, 170, 134, 18);
		contentPane.add(cbPagamento);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteWindow janelaPaciente = new PacienteWindow();
				janelaPaciente.setVisible(true);
				janelaPaciente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 245, 89, 23);
		contentPane.add(btnVoltar);

		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setBounds(222, 93, 146, 20);
		contentPane.add(txtTelefone);
	}

}
