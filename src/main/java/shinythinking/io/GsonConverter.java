package shinythinking.io;

import com.google.gson.*;
import shinythinking.model.TaskModel;

import java.time.LocalDate;

public class GsonConverter {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public String serialize(TaskModel taskModel) {
        return gson.toJson(taskModel);
    }

    public TaskModel deserialize(String json) {
        return gson.fromJson(json, TaskModel.class);
    }
}
