package parser;


import com.google.common.reflect.TypeToken;

import java.lang.reflect.Type;

public interface Parser<T> {

    T parse(String filePath, Type type);

}
