
package com.trayis.geocache;

public class Location<K> implements Comparable<Location<K>> {

    private double x;

    private double y;

    private K data;

    /**
     * Creates a new point object.
     *
     * @param {double} x The x-coordinate of the point.
     * @param {double} y The y-coordinate of the point.
     * @param {Object} opt_value Optional value associated with the point.
     */
    public Location(double x, double y, K data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public K getData() {
        return data;
    }

    public void setData(K data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(Location<K> tmp) {
        if (this.x < tmp.x) {
            return -1;
        }

        if (this.x > tmp.x) {
            return 1;
        }

        if (this.y < tmp.y) {
            return -1;
        }

        if (this.y > tmp.y) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Location)) {
            return false;
        }

        Location<?> another = (Location<?>)obj;
        if (!another.data.getClass().equals(data.getClass())) {
            return false;
        }

        return (x == another.x && y == another.y);
    }

    @Override
    public int hashCode() {
        int hashCode = 91;

        long doubleFieldBits = Double.doubleToLongBits(x);
        hashCode = 113 * hashCode + (int)(doubleFieldBits ^ (doubleFieldBits >>> 32));

        doubleFieldBits = Double.doubleToLongBits(y);
        hashCode = 113 * hashCode + (int)(doubleFieldBits ^ (doubleFieldBits >>> 32));

        hashCode = 113 * hashCode + data.hashCode();

        return hashCode;
    }
}
