package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Exame;
import entities.ExameAgendado;
import service.ExameAgendadoService;
import service.ExameService;

public class AgendaMedicoWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAgenda;
	private JTextField txtCrm;

	private ExameAgendadoService exameAgenadoService;
	private ExameService exameService;
	private List<ExameAgendado> listaExames;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel painelAlunos = new JPanel();
		painelAlunos.setLayout(null);
		painelAlunos.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Agenda",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelAlunos.setBounds(10, 60, 465, 269);
		contentPane.add(painelAlunos);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 446, 235);
		painelAlunos.add(scrollPane);

		tblAgenda = new JTable();
		DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Data", "Hora", "Exame", "Paciente", "Valor" });
		tblAgenda.setModel(tblModel);
		definirLargurasColunas();

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
					exameAgenadoService = new ExameAgendadoService();
					listaExames = exameAgenadoService.buscarTodas(Integer.parseInt(txtCrm.getText()));
					atualizarTabela();
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
				MedicoWindow janelaMedico = new MedicoWindow();
				janelaMedico.setVisible(true);
				janelaMedico.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(373, 10, 100, 23);
		contentPane.add(btnVoltar);
	}

	private void definirLargurasColunas() {
		tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(60); // Data
		tblAgenda.getColumnModel().getColumn(1).setPreferredWidth(40); // Hora
		tblAgenda.getColumnModel().getColumn(2).setPreferredWidth(100); // Exame
		tblAgenda.getColumnModel().getColumn(3).setPreferredWidth(150); // Paciente
		tblAgenda.getColumnModel().getColumn(4).setPreferredWidth(30); // Valor
	}

	private void atualizarTabela() {
	    DefaultTableModel model = (DefaultTableModel) tblAgenda.getModel();
	    model.setRowCount(0);

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

	    definirLargurasColunas();
	}

}
