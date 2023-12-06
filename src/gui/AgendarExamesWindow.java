package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import entities.Exame;
import entities.ExameAgendado;
import service.ExameAgendadoService;
import service.ExameService;
import javax.swing.SwingConstants;

public class AgendarExamesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;
	private JFormattedTextField txtData;
	private JFormattedTextField txtHora;
	private JTextField txtValor;
	private JComboBox cbExames;
	private ExameService exameService;
	private ExameAgendadoService exameAgendadoService;
	private MaskFormatter mascaraData;
	private MaskFormatter mascaraHora;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendarExamesWindow frame = new AgendarExamesWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgendarExamesWindow() {
		
		criarMascaraData();
		criarMascaraHora();
		this.initComponents();
		exameService = new ExameService();
		exameAgendadoService = new ExameAgendadoService();
		this.popularComboBox();
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
	
	private void popularComboBox() {
		
		try {

			List<Exame> exames = this.exameService.buscarExames();

			for (Exame exame: exames) {
				this.cbExames.addItem(exame.getNome());
			}

		} catch (SQLException | IOException e) {

			JOptionPane.showMessageDialog(null, "Erro ao buscar os exames.", "Busca de Exames",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void agendarExame() {
		
		try {
			ExameAgendado exameAg = new ExameAgendado();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			exameAg.setNomePaciente(this.txtNome.getText());
			exameAg.setCrm(Integer.parseInt(this.txtCRM.getText()));
			exameAg.setValorPago(Double.parseDouble(this.txtValor.getText()));
			exameAg.setData(new java.sql.Date(sdf.parse(this.txtData.getText()).getTime()));
			exameAg.setHora(Time.valueOf(LocalTime.parse(this.txtHora.getText())));
			exameAg.setCodigoExame(this.cbExames.getSelectedIndex() + 1);
			this.exameAgendadoService.agendar(exameAg);
			JOptionPane.showMessageDialog(null, "Exame agendado com sucesso." , "Exame",
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException | SQLException | ParseException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro ao agendar exame." + e.getMessage(), "Agendar exame",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agendar exames");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(120, 11, 167, 18);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblTitulo);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 58, 224, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome do paciente:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(19, 61, 127, 14);
		contentPane.add(lblNome);
		
		JLabel lblCRM = new JLabel("CRM:");
		lblCRM.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCRM.setBounds(19, 109, 46, 14);
		contentPane.add(lblCRM);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(60, 106, 86, 20);
		contentPane.add(txtCRM);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(19, 152, 46, 14);
		contentPane.add(lblData);
		
		txtData = new JFormattedTextField (mascaraData);
		txtData.setFont(new Font("Arial", Font.PLAIN, 12));
		txtData.setBounds(60, 149, 70, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setBounds(242, 151, 86, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 12));
		txtValor.setBounds(283, 149, 70, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteWindow janelaPacientel = new PacienteWindow();
				janelaPacientel.setVisible(true);
				janelaPacientel.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 199, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnTiposExame = new JButton("Tipos de Exame");
		btnTiposExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				TiposExameWindow tiposExameWindow = new TiposExameWindow();
				tiposExameWindow.setVisible(true);
				tiposExameWindow.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnTiposExame.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTiposExame.setBounds(123, 199, 127, 23);
		contentPane.add(btnTiposExame);
		
		JButton btnCadastrar = new JButton("Agendar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agendarExame();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(274, 199, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblExame = new JLabel("Exame:");
		lblExame.setFont(new Font("Arial", Font.PLAIN, 12));
		lblExame.setBounds(162, 109, 46, 14);
		contentPane.add(lblExame);
		
		cbExames = new JComboBox<Exame>();
		cbExames.setBounds(210, 106, 143, 22);
		contentPane.add(cbExames);
		
		txtHora = new JFormattedTextField(mascaraHora);
		txtHora.setFont(new Font("Arial", Font.PLAIN, 12));
		txtHora.setColumns(10);
		txtHora.setBounds(180, 149, 40, 20);
		contentPane.add(txtHora);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Arial", Font.PLAIN, 12));
		lblHora.setBounds(139, 151, 46, 14);
		contentPane.add(lblHora);
		
	}
}
