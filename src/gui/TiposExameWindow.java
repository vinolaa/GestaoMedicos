package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import entities.Exame;
import service.ExameService;

public class TiposExameWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblExames;
	private ExameService exameService;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiposExameWindow frame = new TiposExameWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TiposExameWindow() {
		
		this.initComponents();
		this.exameService = new ExameService();
		this.buscarExames();
	}
	
	private void buscarExames() {
		
		try {		
			DefaultTableModel modelo = (DefaultTableModel) tblExames.getModel();
			modelo.fireTableDataChanged();
			modelo.setRowCount(0);
	
			List<Exame> exames = this.exameService.buscarExames();
	
			for (Exame exame : exames) {
	
				modelo.addRow(new Object[] { 
					exame.getCodigo(),
					exame.getNome(),
					exame.getValor(),
					exame.getOrientacoes()
				});
			}
		} catch (SQLException | IOException e) {
			
			System.out.println("Erro ao buscar aluno.");
		}
	}
	
	private void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Exames oferecidos pela clínica");
		lblTitulo.setBounds(21, 11, 259, 18);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
		contentPane.add(lblTitulo);
		
		JPanel painelExames = new JPanel();
		painelExames.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Exames", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		painelExames.setBounds(10, 52, 414, 198);
		contentPane.add(painelExames);
		painelExames.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 423, 386);
		painelExames.add(scrollPane);
		
		tblExames = new JTable();
		scrollPane.setViewportView(tblExames);
		
		tblExames.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cod", "Nome", "Valor", "Orientações"}));
		int[] columnWidths = { 10, 100, 30, 150 }; // tamanho das colunas

        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tblExames.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgendarExamesWindow verificarExamesWindow = new AgendarExamesWindow();
				verificarExamesWindow.setVisible(true);
				verificarExamesWindow.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBounds(318, 10, 89, 23);
		contentPane.add(btnVoltar);
	}

	/**
	 * Create the frame.
	 */
}
