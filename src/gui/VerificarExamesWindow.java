package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entities.Exame;
import entities.ExameAgendado;
import service.ExameAgendadoService;
import service.ExameService;

public class VerificarExamesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCRM;
	private JTextField txtData;
	private JTextField txtValor;
	private JComboBox cbExames;
	private ExameService exameService;
	private ExameAgendadoService exameAgendadoService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerificarExamesWindow frame = new VerificarExamesWindow();
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
	public VerificarExamesWindow() {
		
		this.initComponents();
		exameService = new ExameService();
		exameAgendadoService = new ExameAgendadoService();
		this.popularComboBox();
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
			
			System.out.println(exameAg);
			
			exameAg.setCodigoExame(this.cbExames.getSelectedIndex() + 1);
			
			this.exameAgendadoService.agendar(exameAg);
			
		} catch (IOException | SQLException | ParseException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo paciente." + e.getMessage(), "Cadastro",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agendar exames");
		lblTitulo.setBounds(158, 10, 127, 18);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblTitulo);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 45, 264, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome do paciente:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNome.setBounds(19, 48, 127, 14);
		contentPane.add(lblNome);
		
		JLabel lblCRM = new JLabel("CRM:");
		lblCRM.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCRM.setBounds(19, 102, 46, 14);
		contentPane.add(lblCRM);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(75, 99, 86, 20);
		contentPane.add(txtCRM);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Arial", Font.PLAIN, 12));
		lblData.setBounds(19, 156, 46, 14);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setFont(new Font("Arial", Font.PLAIN, 12));
		txtData.setBounds(75, 153, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor pago:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 12));
		lblValor.setBounds(216, 102, 86, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 12));
		txtValor.setBounds(307, 99, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaInicialWindow janelaTelaInicial = new TelaInicialWindow();
				janelaTelaInicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(16, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnTiposExame = new JButton("Tipos de Exame");
		btnTiposExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TiposExameWindow tiposExameWindow = new TiposExameWindow();
				tiposExameWindow.setVisible(true);
				dispose();
			}
		});
		btnTiposExame.setFont(new Font("Arial", Font.PLAIN, 12));
		btnTiposExame.setBounds(158, 227, 127, 23);
		contentPane.add(btnTiposExame);
		
		JButton btnCadastrar = new JButton("Agendar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agendarExame();
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastrar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblExame = new JLabel("Exame:");
		lblExame.setFont(new Font("Arial", Font.PLAIN, 12));
		lblExame.setBounds(221, 156, 46, 14);
		contentPane.add(lblExame);
		
		cbExames = new JComboBox<Exame>();
		cbExames.setBounds(277, 152, 116, 22);
		contentPane.add(cbExames);
		
	}
}
