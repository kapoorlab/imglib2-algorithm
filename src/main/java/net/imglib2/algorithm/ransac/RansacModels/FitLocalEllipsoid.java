package net.imglib2.algorithm.ransac.RansacModels;

import java.util.ArrayList;
import net.imglib2.RealLocalizable;


public class FitLocalEllipsoid {

	
	
	public static RansacFunctionEllipsoid findLocalEllipsoid(
			final ArrayList<RealLocalizable> points, int ndims) 
	{
		

		final ArrayList<RealLocalizable> remainingPoints = new ArrayList<RealLocalizable>();
		if (points != null)
			remainingPoints.addAll(points);
		int size = points.size();
		final double[] pointA = new double[ndims];
		final double[] pointB = new double[ndims];
		final double[] pointC = new double[ndims];
		
		int splitindex;
		if (size % 2 == 0)
			splitindex = size / 2;
		else
			splitindex = (size - 1) / 2;
		
			for (int i = 0; i < ndims; ++i) {
			pointA[i] = points.get(0).getDoublePosition(i);
			pointB[i] = points.get(splitindex).getDoublePosition(i);
			pointC[i] = points.get(size - 1).getDoublePosition(i);
			
			}
			
		
		
		
		final Circle ellipsoid = Circle.FitCircle(pointA, pointB, pointC);
				
				//FitEllipsoid.yuryPetrov(coordinates, ndims);
		RansacFunctionEllipsoid localellipse = new RansacFunctionEllipsoid(ellipsoid, points, points);
		
		
		return localellipse;
		
		
		
		
		
		
		
	}
	
	
}
