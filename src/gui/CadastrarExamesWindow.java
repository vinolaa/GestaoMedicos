package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class CadastrarExamesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;
	private JTextField txtValor;

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
	public CadastrarExamesWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(20, 57, 49, 14);
		contentPane.add(lblNome);
		
		JLabel lblCod = new JLabel("Código:");
		lblCod.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCod.setBounds(20, 97, 49, 14);
		contentPane.add(lblCod);
		
		txtNome = new JTextField();
		txtNome.setBounds(79, 54, 254, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(79, 94, 96, 20);
		contentPane.add(txtCRM);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aqui, enviar código e nome da especialidade para alguma classe da Service
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(286, 237, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCadastroExames = new JLabel("Cadastro de Exames");
		lblCadastroExames.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroExames.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroExames.setBounds(111, 11, 189, 34);
		contentPane.add(lblCadastroExames);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setBounds(20, 137, 46, 14);
		contentPane.add(lblValor);
		
		try {
			MaskFormatter mascaraValor = new MaskFormatter("R$ ######");
			// ajeitar maskformatter para aceitar valores com vírgula
			txtValor = new JFormattedTextField(mascaraValor);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
		txtValor.setColumns(10);
		txtValor.setBounds(79, 134, 96, 20);
		contentPane.add(txtValor);
		
		JLabel lblObservacoes = new JLabel("Obs:");
		lblObservacoes.setFont(new Font("Arial", Font.PLAIN, 12));
		lblObservacoes.setBounds(20, 176, 46, 14);
		contentPane.add(lblObservacoes);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBounds(79, 165, 254, 63);
		contentPane.add(textArea);
	}
}
