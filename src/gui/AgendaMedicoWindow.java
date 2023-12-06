package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import entities.Consulta;
import entities.Exame;
import entities.ExameAgendado;
import service.ConsultaService;
import service.ExameAgendadoService;
import service.ExameService;

public class AgendaMedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAgenda;
	private JTextField txtCrm;
	private JRadioButton rdExame;
	private JRadioButton rdConsulta;
	private ButtonGroup radioGroup;

	private ExameAgendadoService exameAgendadoService;
	private ConsultaService consultaService;
	private List<ExameAgendado> listaExames;
	private List<Consulta> listaConsultas;

	private ExameService exameService;
	private Exame exame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaMedicoWindow frame = new AgendaMedicoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgendaMedicoWindow() {
		initComponents();
	}

	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		rdExame = new JRadioButton("Exame");
		rdExame.setBounds(158, 10, 80, 23);
		contentPane.add(rdExame);

		rdConsulta = new JRadioButton("Consulta");
		rdConsulta.setBounds(158, 36, 80, 23);
		contentPane.add(rdConsulta);

		radioGroup = new ButtonGroup();
		radioGroup.add(rdExame);
		radioGroup.add(rdConsulta);

		JPanel painelAgenda = new JPanel();
		painelAgenda.setLayout(null);
		painelAgenda.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Agenda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelAgenda.setBounds(10, 60, 465, 269);
		contentPane.add(painelAgenda);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 446, 235);
		painelAgenda.add(scrollPane);

		tblAgenda = new JTable();
		DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Data", "Hora", "Exame", "Paciente", "Valor" });
		tblAgenda.setModel(tblModel);
		definirLargurasColunas(tblAgenda);
		scrollPane.setViewportView(tblAgenda);

		txtCrm = new JTextField();
		txtCrm.setText("");
		txtCrm.setColumns(10);
		txtCrm.setBounds(45, 11, 96, 20);
		contentPane.add(txtCrm);

		JLabel lblCrm = new JLabel("CRM:");
		lblCrm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCrm.setBounds(10, 14, 40, 14);
		contentPane.add(lblCrm);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rdExame.isSelected()) {
						exameAgendadoService = new ExameAgendadoService();
						listaExames = exameAgendadoService.buscarTodas(Integer.parseInt(txtCrm.getText()));
						atualizarTabela(listaExames, true);
					} else if (rdConsulta.isSelected()) {
						consultaService = new ConsultaService();
						listaConsultas = consultaService.buscarTodas(Integer.parseInt(txtCrm.getText()));
						atualizarTabela(listaConsultas, false);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione Exame ou Consulta", "Agenda exames",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (NumberFormatException | SQLException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar exames.", "Agenda exames",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnBuscar.setBounds(255, 10, 100, 23);
		contentPane.add(btnBuscar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Implemente o código para voltar à janela anterior
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(373, 10, 100, 23);
		contentPane.add(btnVoltar);
	}

	private void definirLargurasColunas(JTable tabela) {
	    int[] larguras = {60, 40, 100, 150, 30};

	    for (int i = 0; i < Math.min(tabela.getColumnCount(), larguras.length); i++) {
	        tabela.getColumnModel().getColumn(i).setPreferredWidth(larguras[i]);
	    }
	}


	private void atualizarTabela(List<?> lista, boolean isExame) {
		DefaultTableModel model = (DefaultTableModel) tblAgenda.getModel();
		model.setRowCount(0);

		if (isExame) {
			// Se a opção de exame estiver selecionada, altere as colunas e nomes
			model.setColumnIdentifiers(new String[] { "Data", "Hora", "Exame", "Paciente", "Valor" });
			for (ExameAgendado exameAg : listaExames) {
				try {
					exameService = new ExameService();
					Exame exame = exameService.buscarPorCodigo(exameAg.getCodigoExame());
					model.addRow(new Object[] { exameAg.getData(), exameAg.getHora(), exame.getNome(),
							exameAg.getNomePaciente(), exameAg.getValorPago() });
				} catch (SQLException | IOException e) {
					JOptionPane.showMessageDialog(null, "Nenhum tipo deste exame encontrado.", "Agenda exames",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} else {
			// Se a opção de consulta estiver selecionada, altere as colunas e nomes
			model.setColumnIdentifiers(new String[] { "Data da Consulta", "Hora da Consulta", "Nome do Paciente" });
			for (Object obj : lista) {
				Consulta consulta = (Consulta) obj;
				// Adapte conforme necessário, dependendo da estrutura do seu código
				model.addRow(
						new Object[] { consulta.getDataConsulta(), consulta.getHoraCosulta(), consulta.getPaciente() });
			}
		}

		definirLargurasColunas(tblAgenda);
	}
}
