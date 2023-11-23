package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.Especialidade;
import entities.Medico;
import service.EspecialidadeService;
import service.MedicoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class CadastrarMedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;
	private JTextField txtEndereco;
	private JFormattedTextField txtTelefone;
	private MaskFormatter mascaraTelefone;
	private JComboBox<Especialidade> cbEspecialidade;

	private MedicoService medicoService;
	private EspecialidadeService especialidadeService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMedicoWindow frame = new CadastrarMedicoWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadastrarMedicoWindow() {
		criarMascaraTelefone();
		initComponents();

		medicoService = new MedicoService();
		especialidadeService = new EspecialidadeService();

		this.buscarEspecialidades();
		this.limparComponentes();

	}

	private void limparComponentes() {

		this.txtNome.setText("");
		this.txtCRM.setText("");
		this.txtTelefone.setText("");
		this.txtEndereco.setText("");
		this.cbEspecialidade.setSelectedIndex(0);
	}

	private void criarMascaraTelefone() {
		try {
			this.mascaraTelefone = new MaskFormatter("#####-####");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	public void cadastrarMedico() {
		try {

			Medico medico = new Medico();

			medico.setNome(this.txtNome.getText());
			medico.setCrm(Integer.parseInt(this.txtCRM.getText()));
			medico.setEndereco(this.txtEndereco.getText());
			medico.setTelefone(this.txtTelefone.getText());
			Especialidade especialidade = (Especialidade) this.cbEspecialidade.getSelectedItem();
			medico.setEspecialidade(especialidade);
			System.out.println(medico);
			this.medicoService.cadastrar(medico);
			JOptionPane.showMessageDialog(null, "Médico cadastrado.", "Cadastro de médico",
					JOptionPane.INFORMATION_MESSAGE);
			this.limparComponentes();
		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo médico.", "Cadastro",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void buscarEspecialidades() {

		try {

			List<Especialidade> especialidades = this.especialidadeService.buscarTodas();

			for (Especialidade especialidade : especialidades) {
				this.cbEspecialidade.addItem(especialidade);
			}

		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao buscar os dados dos pagamentos.", "Busca de Pagamento",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 310);
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
		txtNome.setBounds(56, 60, 264, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(45, 97, 96, 20);
		contentPane.add(txtCRM);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(75, 135, 245, 20);
		contentPane.add(txtEndereco);

		cbEspecialidade = new JComboBox<Especialidade>();
		cbEspecialidade.setBounds(104, 173, 216, 22);
		contentPane.add(cbEspecialidade);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarMedico();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(231, 218, 89, 23);
		contentPane.add(btnCadastrar);

		JLabel lblCadastroDeMdico = new JLabel("Cadastro do Médico");
		lblCadastroDeMdico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeMdico.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeMdico.setBounds(75, 11, 189, 34);
		contentPane.add(lblCadastroDeMdico);

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
		btnVoltar.setBounds(10, 218, 89, 23);
		contentPane.add(btnVoltar);

		txtTelefone = new JFormattedTextField(mascaraTelefone);
		txtTelefone.setBounds(226, 97, 93, 20);
		contentPane.add(txtTelefone);
	}
}
