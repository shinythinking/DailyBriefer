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

    public MainController(TaskModel model, DailyBrieferView mainView, EditView editView) {
        this.model = model;
        this.mainView = mainView;
        this.editView = editView;

        init();
    }

    private void init() {
        mainView.setUpdateTime(LocalDate.now().toString());
        mainView.setTaskCards(model.getTasks());
        mainView.setVisible(true);
    }
}
