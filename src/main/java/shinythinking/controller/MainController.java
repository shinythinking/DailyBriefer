package shinythinking.controller;

import shinythinking.model.Task;
import shinythinking.view.DailyBrieferView;
import shinythinking.view.EditView;
import shinythinking.model.TaskModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.time.LocalDate;

/*
1. 새로고침
2. 편집으로 넘어가기
 */
public class MainController {
    private TaskModel model;
    private DailyBrieferView mainView;
    private EditView editView;
    private ClosingButtonListener closingButtonListener = new ClosingButtonListener();

    public MainController(TaskModel model, DailyBrieferView mainView, EditView editView) {
        this.model = model;
        this.mainView = mainView;
        this.editView = editView;

        init();
        mainView.addEditButtonListener(new EditButtonListener());
        mainView.addRefreshButtonListener(new RefreshButtonListener());
        mainView.addWindowListener(closingButtonListener);
        editView.addAddButtonListener(new AddButtonListener());
        editView.addClearButtonListener(new ClearButtonListener());
        editView.addDeleteButtonListener(new DeleteButtonListener());
        editView.addBackButtonListener(new BackButtonListener());
        editView.addWindowListener(closingButtonListener);
    }

    private void init() {
        mainView.setUpdateTime(LocalDate.now().toString());
        mainView.setTaskCards(model.getTasks());
        mainView.setVisible(true);
    }

    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editView.loadTasks(model.getTasks());
            mainView.setVisible(false);
            editView.setVisible(true);
        }
    }

    private class RefreshButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.refreshAll();
            mainView.revalidate();
            mainView.repaint();
        }
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] input = editView.getInputValues();
            String taskTitle = input[0];
            String taskUrl = input[1];
            String taskElement = input[2];
            String userID = input[3];
            boolean done = input[4].equals("true");
            if (taskTitle.trim().isEmpty() || taskUrl.trim().isEmpty() || userID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(editView, "입력값이 유효하지 않습니다. 모든 필수 필드를 채워주세요.",
                        "입력 오류", JOptionPane.WARNING_MESSAGE);
                return;
            }

            editView.clearInputFields();

            Task newTask = new Task();
            newTask.init(taskTitle, taskUrl, taskElement, done, LocalDate.now(), userID);
            model.addTask(newTask);

            editView.loadTasks(model.getTasks());
            editView.revalidate();
            editView.repaint();
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editView.clearInputFields();
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int row = e.getID();
            if (row >= 0 && row < model.getTasks().size()) {
                model.removeTask(row);
                editView.loadTasks(model.getTasks());
                editView.revalidate();
                editView.repaint();
            }
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            editView.setVisible(false);
            mainView.setTaskCards(model.getTasks());
            mainView.revalidate();
            mainView.repaint();
            mainView.setVisible(true);
        }
    }

    private class ClosingButtonListener extends WindowAdapter {
        @Override
        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            int confirm = JOptionPane.showConfirmDialog(
                    null, "프로그램을 종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                model.saveTaskModel();
                System.exit(0);
            }
        }
    }
}
