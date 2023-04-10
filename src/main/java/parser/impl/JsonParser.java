package parser.impl;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import parser.Parser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonParser<T> implements Parser<T> {
    public T parse(String filePath, TypeToken<T> token) {
        GsonBuilder gson = new GsonBuilder();
        T myJson = null;
        try {
            InputStream stream = getClass().getClassLoader().getResourceAsStream(filePath);
            JsonReader reader = new JsonReader(new InputStreamReader(stream));
            reader.setLenient(true);
            myJson = gson.create().fromJson(reader, token.getType());
        } catch (Exception e) {
            System.out.println(e);
        }
        return myJson;
    }

    private TypeToken getToken() {
        return new TypeToken<>() {};
    }
}
