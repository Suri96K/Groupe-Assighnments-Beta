import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GUI_Action extends JPanel{ //implements ActionListener{
	static JTable stockvalue;
	static Font f= new Font("Calibri", Font.BOLD, 23);
			
	static String[][] data = {	{"FB", NameSet.getStockKey("FB"), String.valueOf(NameSet.getStockPrice("FB"))},
			{"VRTU", NameSet.getStockKey("VRTU"), String.valueOf(NameSet.getStockPrice("VRTU"))},
			{"MSFT", NameSet.getStockKey("MSFT"), String.valueOf(NameSet.getStockPrice("MSFT"))},
			{"GOOGL", NameSet.getStockKey("GOOGL"), String.valueOf(NameSet.getStockPrice("GOOGL"))},
			{"YHOO", NameSet.getStockKey("YHOO"), String.valueOf(NameSet.getStockPrice("YHOO"))},
			{"XLNX", NameSet.getStockKey("XLNX"), String.valueOf(NameSet.getStockPrice("XLNX"))},
			{"TSLA", NameSet.getStockKey("TSLA"), String.valueOf(NameSet.getStockPrice("TSLA"))},
			{"TXN", NameSet.getStockKey("TXN"), String.valueOf(NameSet.getStockPrice("TXN"))}};
	
	public GUI_Action(){
		String[] columns = {"Symbol", "Key", "Price"};
		

		stockvalue = new JTable(data, columns) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int data, int columns) {
				return false;
			}
		};
		stockvalue.setPreferredScrollableViewportSize(new Dimension(1000, 250));
		stockvalue.setFillsViewportHeight(true);
		stockvalue.setRowHeight(30);
		stockvalue.getColumnModel().getColumn(0).setPreferredWidth(150);
		stockvalue.getColumnModel().getColumn(1).setPreferredWidth(450);
		stockvalue.getColumnModel().getColumn(2).setPreferredWidth(400);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		stockvalue.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		stockvalue.setFont(f);
		
		JScrollPane jps = new JScrollPane(stockvalue);
		stockvalue.getTableHeader().setPreferredSize(new Dimension(jps.getWidth(), 40));
		stockvalue.getTableHeader().setFont(new Font("Calibri", Font.BOLD, 23));
		add(jps);
	}
	
}