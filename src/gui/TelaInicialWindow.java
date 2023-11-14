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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicialWindow frame = new TelaInicialWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicialWindow() {
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGerarRelatorio.setBounds(108, 267, 169, 23);
		contentPane.add(btnGerarRelatorio);

		JButton btnCadastrarMedico = new JButton("Cadastrar Médico");
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarMedicoWindow janelaCadastroMedico = new CadastrarMedicoWindow();
				janelaCadastroMedico.setVisible(true);
				dispose();
			}
		});
		btnCadastrarMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarMedico.setBounds(10, 159, 169, 23);
		contentPane.add(btnCadastrarMedico);
		
		JButton btnCadastrarEspecialidade = new JButton("Cadastrar Especialidade");
		btnCadastrarEspecialidade.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        CadastrarEspecialidadeWindow janelaCadastroEspecialidade = new CadastrarEspecialidadeWindow();
		        janelaCadastroEspecialidade.setVisible(true);
		        dispose();
		    }
		});
		btnCadastrarEspecialidade.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarEspecialidade.setBounds(10, 217, 169, 23);
		contentPane.add(btnCadastrarEspecialidade);

		JButton btnAgendarConsulta = new JButton("Agendar Consulta");
		btnAgendarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendarConsultaWindow janelaAgendarConsulta = new AgendarConsultaWindow();
				janelaAgendarConsulta.setVisible(true);
				dispose();
			}
		});
		btnAgendarConsulta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendarConsulta.setBounds(189, 110, 179, 23);
		contentPane.add(btnAgendarConsulta);

		JButton btnVerificarExames = new JButton("Verificar Exames");
		btnVerificarExames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerificarExamesWindow janelaVerificarExames = new VerificarExamesWindow();
				janelaVerificarExames.setVisible(true);
				dispose();
			}
		});
		btnVerificarExames.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVerificarExames.setBounds(189, 159, 179, 23);
		contentPane.add(btnVerificarExames);

		JLabel lblTitulo = new JLabel("Gestão de Médicos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(130, 21, 147, 14);
		contentPane.add(lblTitulo);
		
		JButton btnAdicionarPagamento = new JButton("Adicionar Pagamento");
		btnAdicionarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarPagamentoWindow janelaAdicionarPagamento = new AdicionarPagamentoWindow();
				janelaAdicionarPagamento.setVisible(true);
				dispose();
			}
		});
		btnAdicionarPagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarPagamento.setBounds(189, 217, 179, 23);
		contentPane.add(btnAdicionarPagamento);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarPacienteWindow janelaCadastroPaciente = new CadastrarPacienteWindow();
				janelaCadastroPaciente.setVisible(true);
				dispose();
			}
		});
		btnCadastrarPaciente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrarPaciente.setBounds(10, 110, 169, 23);
		contentPane.add(btnCadastrarPaciente);
	}
}
