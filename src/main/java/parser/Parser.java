package parser;


import com.google.common.reflect.TypeToken;

public interface Parser<T> {

    T parse(String filePath, TypeToken<T> token);

}
