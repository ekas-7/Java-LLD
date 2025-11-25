public class Request {
    private final int fromFloor;
    private final int toFloor;

    public Request(int fromFloor, int toFloor) {
        if (fromFloor < 0 || toFloor < 0) {
            throw new IllegalArgumentException("Floor numbers must be non-negative");
        }
        if (fromFloor == toFloor) {
            throw new IllegalArgumentException("fromFloor and toFloor cannot be the same");
        }
        this.fromFloor = fromFloor;
        this.toFloor = toFloor;
    }

    public int getFromFloor() { return fromFloor; }
    public int getToFloor() { return toFloor; }

    public Direction getDirection() {
        if (toFloor > fromFloor) return Direction.UP;
        if (toFloor < fromFloor) return Direction.DOWN;
        return Direction.NONE; // unreachable due to constructor check, kept for completeness
    }

    @Override
    public String toString() {
        return "Request{" + "from=" + fromFloor + ", to=" + toFloor + ", dir=" + getDirection() + '}';
    }
}
