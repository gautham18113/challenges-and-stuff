package parser.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import parser.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class JsonParser<T> implements Parser<T> {
    public T parse(String filePath, Type typeToken) {
        GsonBuilder gson = new GsonBuilder();
        T myJson = null;
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filePath);
            JsonReader reader = new JsonReader(new InputStreamReader(stream));
            reader.setLenient(true);

            myJson = gson.create().fromJson(reader, typeToken);
        } catch (Exception e) {
            System.out.println(e);
        }
        return myJson;
    }

}
