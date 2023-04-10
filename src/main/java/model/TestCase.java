package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCase<I, O> {

    private I input;
    private O output;
}
