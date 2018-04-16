import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frame extends java.awt.Frame {
	private static final long serialVersionUID = 1L;
	private static final int FRAME_ROW_COUNT = 3;
	JFrame f;
	JTable dispatchTable;
	JTable jt;

	Frame(ProcessTable processTable) {
		f = new JFrame("Main");
		f.setLayout(new GridLayout(FRAME_ROW_COUNT, 1));

		Button dispatchButton = new Button("Dispatch");
		dispatchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame dispatchFrame = new JFrame("Dispatch");
				dispatchFrame.setSize(600, 400);
				dispatchFrame.setVisible(true);

				dispatchTable = new JTable(processTable.dispatch());

				dispatchTable.setBounds(30, 40, 600, 300);
				dispatchFrame.add(new JScrollPane(dispatchTable));
			}
		});

		Button showButton = new Button("Show");

		JPanel menuPanel = new JPanel();
		menuPanel.add(dispatchButton);
		menuPanel.add(showButton);

		f.add(menuPanel);

		TextField burstTimeBox = new TextField();
		TextField arrivalTimeBox = new TextField();
		Button submitProcessButton = new Button("Load Process");

		jt = new JTable(fillTableDataModel(processTable));
		jt.setBounds(30, 40, 200, 300);
		f.add(new JScrollPane(jt));

		submitProcessButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!burstTimeBox.getText().isEmpty() && !arrivalTimeBox.getText().isEmpty()) {
					int burstTIme = Integer.parseInt(burstTimeBox.getText());
					int arrivalTime = Integer.parseInt(arrivalTimeBox.getText());

					processTable.load(processTable.returnNextId(), burstTIme, arrivalTime);
					processTable.notifyData();
//					processTable.process();
					
					fillTableDataModel(processTable);
					
					jt.setModel(fillTableDataModel(processTable));
				}
			}
		});

		JPanel pane = new JPanel();
		pane.setSize(100, 200);

		pane.add(arrivalTimeBox);
		pane.add(burstTimeBox);
		pane.add(submitProcessButton);

		f.add(pane);

		f.setSize(300, 400);
		f.setVisible(true);
	}

	private DefaultTableModel fillTableDataModel(ProcessTable processTable) {
		String data[][] = processTable.processList();
		String column[] = { "Id", "Arrival Time", "Burst Time" };
		DefaultTableModel model = new DefaultTableModel(data, column);

		return model;
	}

	public JTable getDispatchJTable() {
		return dispatchTable;
	}
}
