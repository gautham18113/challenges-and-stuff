package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCases<I, O>{
    private TestCase<I, O>[] testCases;
    private String comparator;
}
