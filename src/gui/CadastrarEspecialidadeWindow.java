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

public class CadastrarEspecialidadeWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;

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
	public CadastrarEspecialidadeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(20, 118, 49, 14);
		contentPane.add(lblNome);
		
		JLabel lblCod = new JLabel("Código:");
		lblCod.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCod.setBounds(20, 143, 49, 14);
		contentPane.add(lblCod);
		
		txtNome = new JTextField();
		txtNome.setBounds(79, 115, 254, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(79, 140, 96, 20);
		contentPane.add(txtCRM);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//aqui, enviar código e nome da especialidade para alguma classe da Service
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(279, 218, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblCadastroDeEspecialidade = new JLabel("Cadastro de Especialidade");
		lblCadastroDeEspecialidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeEspecialidade.setFont(new Font("Arial", Font.BOLD, 18));
		lblCadastroDeEspecialidade.setBounds(57, 11, 276, 34);
		contentPane.add(lblCadastroDeEspecialidade);
	}
}
