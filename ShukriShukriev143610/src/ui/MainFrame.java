package ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Edge;
import main.RAG;
import main.Resource;

public class MainFrame extends Frame {
	private static final long serialVersionUID = 1L;
	JFrame f;
	JTable resourceTable;

	public MainFrame(RAG rag) {
		f = new JFrame("Main");
		f.setLayout(new GridLayout(3, 1));

		resourceTable = new JTable();
		resourceTable.setModel(fillResourceTableDataModel(rag.getResources()));

		f.add(new JScrollPane(resourceTable));

		JPanel processPanel = new JPanel();

		Label processIdLabel = new Label("Process Id");
		TextField processIdTextFiled = new TextField();
		Button submitProcess = new Button("Submit Process");
		submitProcess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (processIdTextFiled.getText() != null && processIdTextFiled.getText() != "") {
					rag.createProcess(processIdTextFiled.getText());
				}
			}
		});

		processPanel.add(processIdLabel);
		processPanel.add(processIdTextFiled);
		processPanel.add(submitProcess);

		f.add(processPanel);

		JPanel menuPanel = new JPanel();
		Button showProcessBtn = new Button("Show Process");
		showProcessBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				JTable processTable = new JTable();
				processTable.setModel(fillProcessTableDataModel(rag.getProcess()));

				frame.add(new JScrollPane(processTable));
				frame.setSize(200, 300);
				frame.setVisible(true);

				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dispose();
					}
				});
			}
		});

		Button processManagerBtn = new Button("Process Manager");

		processManagerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				frame.setLayout(new GridLayout(3, 2));

				Label processIdLabel = new Label("Process Id");
				TextField processIdTextFiled = new TextField();

				Label resourceIdLabel = new Label("Resource Id");
				TextField resourceIdTextFiled = new TextField();

				Button submitRelation = new Button("Add resource to process");
				submitRelation.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if ((processIdTextFiled.getText() != null && processIdTextFiled.getText() != "")
								&& (resourceIdTextFiled.getText() != null && resourceIdTextFiled.getText() != "")) {
							main.Process process = rag.getProcess(processIdTextFiled.getText());
							Resource resource = rag.getResource(resourceIdTextFiled.getText());
							if (process != null && resource != null) {
								rag.processAskResource(process, resource.getLabel());
							}
						}
					}
				});

				JPanel processPane = new JPanel();
				processPane.add(processIdLabel);
				processPane.add(processIdTextFiled);
				frame.add(processPane);

				JPanel resourcePane = new JPanel();
				resourcePane.add(resourceIdLabel);
				resourcePane.add(resourceIdTextFiled);
				frame.add(resourcePane);

				JPanel submitRelationPane = new JPanel();

				submitRelationPane.add(submitRelation);
				frame.add(submitRelationPane);

				frame.setSize(300, 200);
				frame.setVisible(true);
			}
		});

		Button deadLockLocalizator = new Button("Locate Deadlock");

		deadLockLocalizator.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				JTable processTable = new JTable();
				processTable.setModel(fillDeadlockTableDataModel(rag.locateDeadlock()));

				frame.add(new JScrollPane(processTable));
				frame.setSize(200, 300);
				frame.setVisible(true);
				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
						dispose();
					}
				});
			}
		});

		menuPanel.add(showProcessBtn);
		menuPanel.add(processManagerBtn);
		menuPanel.add(deadLockLocalizator);

		f.add(menuPanel);

		f.setSize(300, 400);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	private DefaultTableModel fillResourceTableDataModel(List<Resource> resources) {
		String[][] data = new String[resources.size()][1];

		for (int i = 0; i < resources.size(); i++) {
			data[i][0] = resources.get(i).getLabel();
		}

		String column[] = { "Resource id" };
		DefaultTableModel model = new DefaultTableModel(data, column);

		return model;
	}

	private DefaultTableModel fillProcessTableDataModel(List<main.Process> process) {
		String[][] data = new String[process.size()][2];

		for (int i = 0; i < process.size(); i++) {
			data[i][0] = process.get(i).getLabel();
			data[i][1] = process.get(i).getResourceString();
		}

		String column[] = { "Process id", "Resources" };
		DefaultTableModel model = new DefaultTableModel(data, column);

		return model;
	}
	
	private DefaultTableModel fillDeadlockTableDataModel(List<Edge> locatedDeadlocks) {
		String[][] data = new String[locatedDeadlocks.size()][3];

		for (int i = 0; i < locatedDeadlocks.size(); i++) {
			data[i][0] = locatedDeadlocks.get(i).getProcess().getLabel();
			data[i][1] = locatedDeadlocks.get(i).getResource().getLabel();
			data[i][2] = locatedDeadlocks.get(i).getResource().getRelation().getProcess().getLabel();
		}

		String column[] = { "Process id", "Resources" , "Used by process"};
		DefaultTableModel model = new DefaultTableModel(data, column);

		return model;
	}
}
