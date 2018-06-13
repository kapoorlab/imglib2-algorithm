package net.imglib2.algorithm.ransac.RansacModels;

public class Circle {

	final double[] center;
	final double radii;

	public Circle(final double[] center, final double radii) {

		this.center = center;
		this.radii = radii;

	}

	public static Circle FitCircle(final double[] pa, final double[] pb, final double[] pc) {

		double[] centrad = new double[3];
		// Points can not be collinear
		if ((pa[0] == pb[0] && pb[0] == pc[0]) || (pa[1] == pb[1] && pb[1] == pc[1])) { // colinear coordinates
			centrad[0] = 0; // x
			centrad[1] = 0; // y
			centrad[2] = -1; // radius
			Circle threepoint = new Circle(new double[] { centrad[0], centrad[1] }, centrad[2]);
			return threepoint;
		}

		double a = pb[0] - pa[0];
		double b = pb[1] - pa[1];
		double c = pc[0] - pa[0];
		double d = pc[1] - pa[1];

		double e = a * (pa[0] + pb[0]) + b * (pa[1] + pb[1]);
		double f = c * (pa[0] + pc[0]) + d * (pa[1] + pc[1]);

		double g = 2.0 * (a * (pc[1] - pb[1]) - b * (pc[0] - pb[0]));
		

		if (g == 0.0) {
			centrad[0] = 0; // x
			centrad[1] = 0; // y
			centrad[2] = -1; // radius
		} else { // return centre and radius of the circle
			centrad[0] = (d * e - b * f) / g;
			centrad[1] = (a * f - c * e) / g;
			centrad[2] = Math.sqrt(Math.pow((pa[0] - centrad[0]), 2) + Math.pow((pa[1] - centrad[1]), 2));
		}

		Circle threepoint = new Circle(new double[] { centrad[0], centrad[1] }, centrad[2]);
		return threepoint;

	}

	public double[] getCenter() {

		return center;

	}

	public double getRadii() {

		return radii;
	}

}
