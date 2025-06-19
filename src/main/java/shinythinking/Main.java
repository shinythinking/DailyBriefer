package shinythinking;

import shinythinking.controller.MainController;
import shinythinking.io.LocalIO;
import shinythinking.model.TaskModel;
import shinythinking.view.DailyBrieferView;
import shinythinking.view.EditView;

public class Main {
    public static void main(String[] args) {
        LocalIO localIo = new LocalIO();
        TaskModel taskModel = localIo.loadTaskModel();
        if(taskModel == null){
            taskModel = new TaskModel();
        }

        DailyBrieferView dailyBrieferView = new DailyBrieferView();
        EditView editView = new EditView();
        MainController mainController = new MainController(taskModel, dailyBrieferView, editView);
    }
}
