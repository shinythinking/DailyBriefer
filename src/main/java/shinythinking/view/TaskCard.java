package shinythinking.view;

import shinythinking.model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskCard extends JPanel {
    public TaskCard(Task task) {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));

        Status status;
        if(!task.isValid()){
            status  = Status.WRONG;
        } else if(task.isDone()) {
            status = Status.DONE;
        } else {
            status = Status.NOT_YET;
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;

        JLabel nameLabel = new JLabel(task.getTitle(), SwingConstants.CENTER);
        JLabel statusLabel = new JLabel(status.getMsg(), SwingConstants.CENTER);
        JSeparator separator = new JSeparator();

        gbc.gridy = 0;
        gbc.weighty = 1.0;
        add(nameLabel, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.0;
        add(separator, gbc);

        gbc.gridy = 2;
        gbc.weighty = 3.0;
        statusLabel.setForeground(status.getColor());
        add(statusLabel, gbc);
    }
}