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
		setBounds(100, 100, 383, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGerarRelatorio.setBounds(10, 109, 169, 23);
		contentPane.add(btnGerarRelatorio);

		JLabel lblTitulo = new JLabel("Gestão de Médicos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(121, 21, 147, 14);
		contentPane.add(lblTitulo);
		
		JButton btnAdicionarPagamento = new JButton("Adicionar Pagamento");
		btnAdicionarPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarPagamentoWindow janelaAdicionarPagamento = new AdicionarPagamentoWindow();
				janelaAdicionarPagamento.setVisible(true);
				janelaAdicionarPagamento.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnAdicionarPagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionarPagamento.setBounds(189, 109, 169, 23);
		contentPane.add(btnAdicionarPagamento);
		
		JButton btnPaciente = new JButton("Paciente");
		btnPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteWindow janelaPaciente = new PacienteWindow();
				janelaPaciente.setVisible(true);
				janelaPaciente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnPaciente.setFont(new Font("Arial", Font.BOLD, 14));
		btnPaciente.setBounds(10, 62, 169, 23);
		contentPane.add(btnPaciente);
		
		JButton btnMdico = new JButton("Médico");
		btnMdico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoWindow janelaMedico = new MedicoWindow();
				janelaMedico.setVisible(true);
				janelaMedico.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnMdico.setFont(new Font("Arial", Font.BOLD, 14));
		btnMdico.setBounds(189, 62, 169, 23);
		contentPane.add(btnMdico);
	}
}
