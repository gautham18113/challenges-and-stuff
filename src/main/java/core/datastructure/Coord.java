package core.datastructure;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Coord {
    private final int row;
    private final int col;

    public Coord(int r, int c) {
        this.row = r;
        this.col = c;
    }
}
