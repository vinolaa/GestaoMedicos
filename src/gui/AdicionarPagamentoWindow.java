package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Pagamento;
import service.PagamentoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdicionarPagamentoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFormaPagamento;
	private PagamentoService pagamentoService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarPagamentoWindow frame = new AdicionarPagamentoWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdicionarPagamentoWindow() {
		initComponents();
		
		pagamentoService = new PagamentoService();

	}
	
	private void limparComponentes() {

		this.textFormaPagamento.setText("");
	}
	
	private void cadastrarPagamento() {

		try {
			Pagamento especialidede = new Pagamento();
			especialidede.setFormaPagamento(this.textFormaPagamento.getText());
			this.pagamentoService.cadastrar(especialidede);
			JOptionPane.showMessageDialog(null, "Pagamento cadastrado.", "Cadastro de pagamento",
					JOptionPane.INFORMATION_MESSAGE);
			this.limparComponentes();
		} catch (SQLException | IOException | NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Erro ao cadastrar pagamento.", "Cadastro de pagamento",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 199);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFormaDePagamento_1 = new JLabel("Forma de Pagamento");
		lblFormaDePagamento_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaDePagamento_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblFormaDePagamento_1.setBounds(38, 11, 189, 34);
		contentPane.add(lblFormaDePagamento_1);

		textFormaPagamento = new JTextField();
		textFormaPagamento.setText("");
		textFormaPagamento.setColumns(10);
		textFormaPagamento.setBounds(20, 84, 222, 20);
		contentPane.add(textFormaPagamento);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento:");
		lblFormaDePagamento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFormaDePagamento.setBounds(20, 59, 132, 14);
		contentPane.add(lblFormaDePagamento);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(20, 125, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPagamento();
			}
		});
		btnAdicionar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAdicionar.setBounds(153, 125, 89, 23);
		contentPane.add(btnAdicionar);

	}
}
