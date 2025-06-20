package shinythinking.io;

import shinythinking.model.TaskModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LocalIO {
    GsonConverter gson = new GsonConverter();
    Path dirPath = Paths.get("taskdata");
    Path filePath = dirPath.resolve("taskmodel.json");

    public void saveTaskModel(TaskModel taskModel) {
        try {
            Files.createDirectories(dirPath);

            String json = gson.serialize(taskModel);
            Files.writeString(filePath, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskModel loadTaskModel() {
        try {
            if (!Files.exists(filePath)) {
                return null;
            }

            String json = Files.readString(filePath);
            return gson.deserialize(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
