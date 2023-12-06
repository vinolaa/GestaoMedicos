package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Exame;
import entities.ExameAgendado;
import service.ExameAgendadoService;
import service.ExameService;

public class HistoricoExamesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblAgenda;
	private JComboBox cbExames;

	private ExameAgendadoService exameAgenadoService;
	private ExameService exameService;
	private List<ExameAgendado> listaExames;
	private Exame exame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoExamesWindow frame = new HistoricoExamesWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void popularComboBox() {
		
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
	
	private void gerarRelatorio() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                String filePath = new File(selectedDirectory, "relatorio_exames.csv").getPath();

                FileWriter writer = new FileWriter(filePath);

                // Escrever cabeçalho
                writer.append("Data,Hora,Exame,Paciente,Valor\n");

                // Escrever dados dos exames
                
                for (ExameAgendado exameAg : listaExames) {
                    Exame exame = exameService.buscarPorCodigo(exameAg.getCodigoExame());
                    writer.append(String.format("%s,%s,%s,%s,%.2f\n",
                            exameAg.getData(), exameAg.getHora(), exame.getNome(),
                            exameAg.getNomePaciente(), exameAg.getValorPago()));
                }

                writer.close();
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso.", "Relatório de Exames",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório.", "Relatório de Exames",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException npe) {
        	
        	JOptionPane.showMessageDialog(null,  "Lista de exames vazia", "Relatório de Exames",
        			JOptionPane.ERROR_MESSAGE);
        }
	}

	public HistoricoExamesWindow() {
		
		this.initComponents();
	}
	
	public void initComponents() {
		
		exameService = new ExameService();
		exameAgenadoService = new ExameAgendadoService();
		
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

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipo.setBounds(10, 14, 40, 14);
		contentPane.add(lblTipo);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listaExames = exameAgenadoService.buscarPorTipo(cbExames.getSelectedIndex() + 1);
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
				GerarRelatorioWindow janelaRelatorio = new GerarRelatorioWindow();
				janelaRelatorio.setVisible(true);
				janelaRelatorio.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(373, 10, 100, 23);
		contentPane.add(btnVoltar);
		
		cbExames = new JComboBox();
		cbExames.setBounds(45, 10, 113, 22);
		contentPane.add(cbExames);
		
		JButton btnGerarRelatorio = new JButton("Gerar Relatório");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gerarRelatorio();
			}
		});
		btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 12));
		btnGerarRelatorio.setBounds(300, 37, 139, 23);
		contentPane.add(btnGerarRelatorio);
		
		this.popularComboBox();
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
