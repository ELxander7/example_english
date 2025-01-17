package ru.kpfu.itis.oris.armanov.example_english.util;

import ru.kpfu.itis.oris.armanov.example_english.entity.Question;
import ru.kpfu.itis.oris.armanov.example_english.entity.Test;
import ru.kpfu.itis.oris.armanov.example_english.entity.TestType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class JsonConverter {

    private final Gson gson;

    public JsonConverter() {

        gson = new GsonBuilder().create();
    }

    public String convertToJson(List<Question> quiz) {

        JsonArray jarray = gson.toJsonTree(quiz).getAsJsonArray();
        System.out.println(jarray);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("quiz", jarray);

        return jsonObject.get("quiz").toString();


        /*
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(quiz);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
        * */
    }

}