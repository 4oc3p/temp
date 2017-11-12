import java.math.BigDecimal;

/**
 * Created by 4oc3p on 11.11.2017. temp
 */

public class DotChecker {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x0;
    private double y0;
    private double d;

    /**
     * Constructor
     *
     * @param x1,y1 Coordinates of the first point
     * @param x2,y2 Coordinates of the second point
     * @param x0,y0 Coordinates of verifiable point
     * @param d     maximum distance from each point which lies on segment
     */

    public DotChecker(double x1, double y1, double x2, double y2, double x0, double y0, double d) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x0 = x0;
        this.y0 = y0;
        this.d = d;
    }

    /**
     * @return True if distance from verifiable point to segment is equals or
     * lower than {@link DotChecker#d} and False otherwise
     * @throws RuntimeException when Points ({@param x1,y1} and {@param x2,y2}) are equals.
     */
    public boolean isInCapsule() {
        if (x2 - x1 == 0 && y2 - y1 == 0) {
            throw new RuntimeException("It's a point, not segment");
        }
        /* Find coefficients for linear equation Ax + By + C = 0 */
        double aCoef = y2 - y1;
        double bCoef = x1 - x2;
        double cCoef = y1 * (x2 - x1) - x1 * (y2 - y1);

        /* Finding coordinates of point on segment which belong to perpendicular of (x0, y0) and |AB| */
        double x0p = (bCoef * (bCoef * x0 - aCoef * y0) - aCoef * cCoef) / (Math.pow(aCoef, 2) + Math.pow(bCoef, 2));
        double y0p = (aCoef * (aCoef * y0 - bCoef * x0) - bCoef * cCoef) / (Math.pow(aCoef, 2) + Math.pow(bCoef, 2));

        /* Finding dimensions of segments separated by point (x0p, y0p) */
        double PA = dist(x1, y1, x0p, y0p);
        double PB = dist(x0p, y0p, x2, y2);
        double AB = dist(x1, y1, x2, y2);

        /* Finding from which point calculate distance to verifiable point */
        if (round(PA + PB) <= round(AB)) {
            return round(dist(x0p, y0p, x0, y0)) <= round(d);
        } else if (PA + PB > AB && PA < PB) {
            return round(dist(x1, y1, x0, y0)) <= round(d);
        } else {
            return round(dist(x2, y2, x0, y0)) <= round(d);
        }
    }

    /**
     * @param x1,y1 - first point
     * @param x2,y2 - second point
     * @return double distance of segment |(x1, y1) (x2, y2)|
     */
    private double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * @param a - any double
     * @return double, rounded to fifth digit
     */
    private double round(double a) {
        return BigDecimal.valueOf(a).setScale(5, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }
}