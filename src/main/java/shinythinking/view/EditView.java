package shinythinking.view;

import shinythinking.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class EditView extends JFrame {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JTextField titleField, urlField, userIdField, elementField;
    private JCheckBox doneCheckBox;
    private JButton addButton, clearButton;

    public EditView() {
        setTitle("Edit Tasks");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel tablePanel = createTablePanel();
        add(tablePanel, BorderLayout.CENTER);

        JPanel addPanel = createAddTaskPanel();
        add(addPanel, BorderLayout.SOUTH);
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnNames = {"Task", "Title", "URL", "Target Element", "userID", "Delete"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };

        taskTable = new JTable(tableModel);
        taskTable.getColumn("Delete").setCellRenderer(new DeleteButtonRenderer());
        taskTable.getColumn("Delete").setCellEditor((TableCellEditor) new DeleteButtonEditor(new JCheckBox()));
        taskTable.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createAddTaskPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 0, 5));
        titleField = new JTextField("제목을 입력하세요");
        urlField = new JTextField("URL을 입력하세요.2");
        userIdField = new JTextField();
        leftPanel.add(new JLabel("Title:"));
        leftPanel.add(titleField);
        leftPanel.add(new JLabel("URL:"));
        leftPanel.add(urlField);
        leftPanel.add(new JLabel("UserID:"));
        leftPanel.add(userIdField);


        JPanel rightPanel = new JPanel(new GridLayout(2, 1, 0, 5));
        elementField = new JTextField();
        doneCheckBox = new JCheckBox();
        rightPanel.add(new JLabel("Element:"));
        rightPanel.add(elementField);
        rightPanel.add(new JLabel("Done:"));
        rightPanel.add(doneCheckBox);

        panel.add(leftPanel);
        panel.add(rightPanel);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add");
        clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(clearButton);

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(panel, BorderLayout.CENTER);
        wrapper.add(buttonPanel, BorderLayout.SOUTH);
        return wrapper;
    }

    public void loadTasks(List<Task> tasks) {
        tableModel.setRowCount(0);
        for (Task task : tasks) {
            tableModel.addRow(task.convertToRow());
        }
    }

    public void addAddButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addClearButtonListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public String[] getInputValues() {
        return new String[]{
                titleField.getText(),
                urlField.getText(),
                elementField.getText(),
                userIdField.getText(),
                doneCheckBox.isSelected() ? "true" : "false"
        };
    }

    public void clearInputFields() {
        titleField.setText("");
        urlField.setText("");
        userIdField.setText("");
        elementField.setText("");
        doneCheckBox.setSelected(false);
    }
}
