package model.testcase;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.testcase.TestCase;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TestCases<I, O>{
    private TestCase<I, O>[] testCases;
    private String comparator;
}
