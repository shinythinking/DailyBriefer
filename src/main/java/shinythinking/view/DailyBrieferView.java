package shinythinking.view;

import shinythinking.model.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DailyBrieferView extends JFrame {
    private JLabel appNameLabel;
    private JButton editButton;
    private JPanel taskPanel;
    private JLabel updateTimeLabel;
    private JButton refreshButton;
    private List<TaskCard> taskCards;

    public DailyBrieferView() {
        setTitle("DailyBrief App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        taskCards = new ArrayList<>();

        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        taskPanel = createTaskPanel();
        JScrollPane scrollPane = new JScrollPane(taskPanel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel footerPanel = createFooterPanel();
        add(footerPanel, BorderLayout.SOUTH);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        appNameLabel = new JLabel("DailyBrief", SwingConstants.CENTER);
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(appNameLabel, BorderLayout.CENTER);

        editButton = new JButton("✏️");
        headerPanel.add(editButton, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createTaskPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        refreshButton = new JButton("⟳");
        footerPanel.add(refreshButton, BorderLayout.WEST);

        updateTimeLabel = new JLabel("업데이트: 2025-05-10 14:30", SwingConstants.CENTER);
        footerPanel.add(updateTimeLabel, BorderLayout.CENTER);

        return footerPanel;
    }
    
    public void setTaskCards(List<Task> tasks) {
        for (Task task : tasks) {
            TaskCard taskCard = new TaskCard(task);
            taskCards.add(taskCard);
            taskPanel.add(taskCard);
        }

        taskPanel.revalidate();
        taskPanel.repaint();
    }

    public void setUpdateTime(String time) {
        updateTimeLabel.setText("업데이트: " + time);
    }

    public void addEditButtonListener(ActionListener listener) {
        editButton.addActionListener(listener);
    }

    public void addRefreshButtonListener(ActionListener listener) {
        refreshButton.addActionListener(listener);
    }
}