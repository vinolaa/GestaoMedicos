package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.Consulta;
import entities.ExameAgendado;
import service.ConsultaService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class AgendarConsultaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPaciente;
	private JTextField txtMedico;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraHora;

	private ConsultaService consultaService;

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
		
		consultaService = new ConsultaService();
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

		String a = txtMedico.getText();
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Consulta consulta = new Consulta();
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					consulta.setPaciente(txtPaciente.getText());
					consulta.setMedico(txtMedico.getText());
					consulta.setDataConsulta(new java.sql.Date(sdf.parse(txtData.getText()).getTime()));
					consulta.setHoraCosulta(Time.valueOf(LocalTime.parse(txtHora.getText())));
					consultaService.agendar(consulta);
					JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso.", "Consulta",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException | SQLException | ParseException | NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao agendar consulta." + e1.getMessage(), "Agendar exame",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
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
				PacienteWindow janelaPaciente = new PacienteWindow();
				janelaPaciente.setVisible(true);
				janelaPaciente.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 189, 89, 23);
		contentPane.add(btnVoltar);

	}
}
