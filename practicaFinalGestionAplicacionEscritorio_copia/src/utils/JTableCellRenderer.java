package utils;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;

public class JTableCellRenderer implements TableCellRenderer{

	JTable table = null;
	int row;
	
	// Pinta el Jbutton de forma correcta en la tabla
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
			boolean hasFocus, int row, int column) {
		this.table = table;
	    JButton button = (JButton)value;
	    return button;  
	} // getTableCellRendererComponent

}

