/**
 * Created by 4oc3p on 09.11.2017. temp
 */
public class CircleCollision {
    double x1;
    double y1;
    double x2;
    double y2;
    double r;
    double r2;

    public CircleCollision(double x1, double y1, double x2, double y2, double r, double r2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.r = r;
        this.r2 = r2;
    }

    public String isIntersected() {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (length > r + r2) {
            return "Not intersected";
        } else if (length <= Math.abs(r - r2)) {
            return "Inside";
        } else {
            return "Intersected";
        }
    }
}
