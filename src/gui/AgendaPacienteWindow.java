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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

public class AgendaPacienteWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tblAgenda;

    private ExameAgendadoService exameAgenadoService;
    private ExameService exameService;
    private ConsultaService consultaService;
    private List<ExameAgendado> listaExames;
    private List<Consulta> listaConsultas;
    private Exame exame;
    private JTextField txtNome;
    private JComboBox<String> cbExames;
    private JRadioButton rdbtnExames;
    private JRadioButton rdbtnConsultas;
    private ButtonGroup radioButtonGroup;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AgendaPacienteWindow frame = new AgendaPacienteWindow();
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

            for (Exame exame : exames) {
                this.cbExames.addItem(exame.getNome());
            }

        } catch (SQLException | IOException e) {

            JOptionPane.showMessageDialog(null, "Erro ao buscar os exames.", "Busca de Exames",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gerarRelatorioExames() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                String filePath = new File(selectedDirectory, "relatorio_paciente_exame.txt").getPath();

                FileWriter writer = new FileWriter(filePath);

                writer.append("Data,Hora,Exame,Paciente,Valor\n");

                for (ExameAgendado exameAg : listaExames) {
                    Exame exame = exameService.buscarPorCodigo(exameAg.getCodigoExame());
                    writer.append(String.format("%s,%s,%s,%s,%.2f\n", exameAg.getData(), exameAg.getHora(),
                            exame.getNome(), exameAg.getNomePaciente(), exameAg.getValorPago()));
                }

                writer.close();
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso.", "Relatório de Exames",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório.", "Relatório de Exames",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, "Lista de exames vazia", "Relatório de Exames",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void gerarRelatorioConsultas() {
    	
    	try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Salvar Relatório");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();
                String filePath = new File(selectedDirectory, "relatorio_paciente_consulta.txt").getPath();

                FileWriter writer = new FileWriter(filePath);

                writer.append("Data,Hora,Medico,Paciente,Codigo\n");

                for (Consulta consulta : listaConsultas) {
                    writer.append(String.format("%s,%s,%d,%s,%d\n", consulta.getDataConsulta(), consulta.getHoraCosulta(),
                            consulta.getCrm(), consulta.getPaciente(), consulta.getCodigoConsulta()));
                }

                writer.close();
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso.", "Relatório de Exames",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório.", "Relatório de Exames",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, "Lista de exames vazia", "Relatório de Exames",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public AgendaPacienteWindow() {

        this.initComponents();
        exameService = new ExameService();
        exameAgenadoService = new ExameAgendadoService();
        consultaService = new ConsultaService();
    }

    public void initComponents() {

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

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.PLAIN, 12));
        lblNome.setBounds(10, 14, 40, 14);
        contentPane.add(lblNome);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	if (rdbtnExames.isSelected()) {
            		
            		DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {},
                            new String[] { "Data", "Hora", "Exame", "Paciente", "Valor" });
            		tblAgenda.setModel(tblModel);
            		
            		
            		try {
    					listaExames = exameAgenadoService.buscarPorNome(txtNome.getText());
    					atualizarTabela();
    				} catch (NumberFormatException | SQLException | IOException e1) {
    					JOptionPane.showMessageDialog(null, "Erro ao buscar exames.", "Agenda exames",
    							JOptionPane.ERROR_MESSAGE);
    				}
            	} else if (rdbtnConsultas.isSelected()) {
            		
            		DefaultTableModel tblModel = new DefaultTableModel(new Object[][] {},
                            new String[] { "Data", "Hora", "CRM", "Paciente", "Código" });
            		tblAgenda.setModel(tblModel);
            		try {
            			listaConsultas = consultaService.buscarPorNomePaciente(txtNome.getText());
            			atualizarTabela();
            		} catch (NumberFormatException | SQLException | IOException e1) {
    					JOptionPane.showMessageDialog(null, "Erro ao buscar exames", "Agenda exames",
    							JOptionPane.ERROR_MESSAGE);
    					e1.printStackTrace();
    				}
            		
            		
            	}
            }
        });

        btnBuscar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnBuscar.setBounds(255, 10, 100, 23);
        contentPane.add(btnBuscar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaInicialWindow telaInicial = new TelaInicialWindow();
                telaInicial.setVisible(true);
                telaInicial.setLocationRelativeTo(null);
                dispose();
            }
        });
        btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
        btnVoltar.setBounds(373, 10, 100, 23);
        contentPane.add(btnVoltar);

        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (rdbtnExames.isSelected()) {
                	
                	gerarRelatorioExames();
                }
                
                else if (rdbtnConsultas.isSelected()) {
                	
                	gerarRelatorioConsultas();
                }
            }
        });
        btnGerarRelatorio.setFont(new Font("Arial", Font.PLAIN, 12));
        btnGerarRelatorio.setBounds(300, 37, 139, 23);
        contentPane.add(btnGerarRelatorio);

        txtNome = new JTextField();
        txtNome.setBounds(60, 11, 152, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        rdbtnExames = new JRadioButton("Exames");
        rdbtnExames.setFont(new Font("Arial", Font.PLAIN, 12));
        rdbtnExames.setBounds(10, 37, 80, 23);
        contentPane.add(rdbtnExames);
        rdbtnExames.setSelected(true);

        rdbtnConsultas = new JRadioButton("Consultas");
        rdbtnConsultas.setFont(new Font("Arial", Font.PLAIN, 12));
        rdbtnConsultas.setBounds(95, 37, 90, 23);
        contentPane.add(rdbtnConsultas);
       
       
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(rdbtnExames);
        radioButtonGroup.add(rdbtnConsultas);
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
        
        if (rdbtnExames.isSelected()) {
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
        }
        
        else if (rdbtnConsultas.isSelected()) {
        	
        	for (Consulta consulta: listaConsultas) {
        	
                model.addRow(new Object[] { consulta.getDataConsulta(), consulta.getHoraCosulta(), consulta.getCrm(),
                        consulta.getPaciente(), consulta.getCodigoConsulta() });
        	}
        }

        definirLargurasColunas();
    }
}