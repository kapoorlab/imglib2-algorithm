package net.imglib2.algorithm.ransac.RansacModels;

public class Circle {

	
	final double[] center;
	final double radii;
	
	public Circle (final double[] center, final double radii) {
		
		
		this.center = center;
		this.radii= radii;
		
		
	}
	
	
	
	public static Circle FitCircle(final double[] pointA, final double[] pointB, final double[] pointC) {
		
         		double x1 = pointA[0];
         		double x2 = pointB[0];
         		double x3 = pointC[0];
         		
         		double y1 = pointA[1];
         		double y2 = pointB[1];
         		double y3 = pointC[1];
         		
         		
         		double mr = (y2-y1) / (x2-x1 + 0.1);
         		
         	    double mt = (y3-y2) / (x3-x2 + 0.1);

         	    if (mr == mt) {
         	        
         	    	double xcenter = pointB[0];
         	    	double ycenter = pointB[1];
         	    	double radius = Double.MAX_VALUE;
         	    	Circle threepoint = new Circle(new double[] {xcenter,  ycenter} , radius);
         			
               	return threepoint;
         	    	
         	    }
         	    else {
         		
         	   double xcenter = -(mr * mt * (y1 - y3) - mr * (x2 + x3) + mt * (x1 + x2)) / (2 * (mr - mt));
         	   double ycenter =  mr * (xcenter - x1) + y1;
         	  double radius = Math.pow((Math.pow((x2-xcenter), 2) +  Math.pow((y2-ycenter), 2)), 0.5);
		
		
         	  Circle threepoint = new Circle(new double[] {xcenter,  ycenter} , radius);
		
         	  return threepoint;
	}
	}
	
	public  double[] getCenter() {
		
		return center;
		
	}
	
	public double getRadii() {
		
		return radii;
	}
	
	
}
