package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgendarConsultaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPaciente;
	private JTextField txtMedico;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraHora;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendarConsultaWindow frame = new AgendarConsultaWindow();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgendarConsultaWindow() {
		criarMascaraData();
		criarMascaraHora();
		initComponents();

	}
	
	private void criarMascaraData() {
		try {
			this.mascaraData = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}
	
	private void criarMascaraHora() {
		try {
			this.mascaraHora = new MaskFormatter("##:##");
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Paciente:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(10, 59, 61, 14);
		contentPane.add(lblNome);

		JLabel lblMedico = new JLabel("Médico:");
		lblMedico.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMedico.setBounds(10, 97, 49, 14);
		contentPane.add(lblMedico);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDia.setBounds(10, 136, 49, 14);
		contentPane.add(lblDia);

		JLabel lblHora = new JLabel("Horário:");
		lblHora.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHora.setBounds(140, 136, 49, 14);
		contentPane.add(lblHora);

		JFormattedTextField txtData = new JFormattedTextField(mascaraData);
		txtData.setBounds(37, 133, 77, 20);
		contentPane.add(txtData);

		JFormattedTextField txtHora = new JFormattedTextField(mascaraHora);
		txtHora.setBounds(194, 133, 41, 20);
		contentPane.add(txtHora);

		txtPaciente = new JTextField();
		txtPaciente.setBounds(73, 56, 162, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);

		txtMedico = new JTextField();
		txtMedico.setColumns(10);
		txtMedico.setBounds(61, 94, 174, 20);
		contentPane.add(txtMedico);

		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgendar.setBounds(142, 189, 89, 23);
		contentPane.add(btnAgendar);

		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendarConsulta.setFont(new Font("Arial", Font.BOLD, 18));
		lblAgendarConsulta.setBounds(37, 11, 174, 34);
		contentPane.add(lblAgendarConsulta);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 189, 89, 23);
		contentPane.add(btnVoltar);

	}
}
