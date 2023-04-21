package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TestCases<I, O>{
    private TestCase<I, O>[] testCases;
    private String comparator;
}
