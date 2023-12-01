package bondarev;

import java.util.Objects;

public class Coordinates {
    public final int X;
    public final int Y;


    public Coordinates(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }


    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(this.X + shift.Xshift, this.Y + shift.Yshift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int x = X + shift.Xshift;
        int y = Y + shift.Yshift;

        if ((x < 0) || (x > 40)) return false;
        if ((y < 0) || (y > 10)) return false;

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return X == that.X && Y == that.Y;
    }
}
