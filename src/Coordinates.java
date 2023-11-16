import java.util.Objects;

public class Coordinates {
    public final Integer axisX;
    public final Integer axisY;

    public Coordinates(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return axisX == that.axisX && axisY == that.axisY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(axisX, axisY);
    }
}
