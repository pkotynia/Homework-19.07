package com.company.task1;

import java.util.ArrayList;
import java.util.List;

public class Circle implements Resizable {

    private Point2D center;
    private Point2D point;
    private double surfaceArea;
    private double radius;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }


    private double getRadius() {
        double yDisctance = point.getY() - center.getY();
        double xDistance = point.getX() - center.getX();
        return Math.sqrt(yDisctance * yDisctance + xDistance * xDistance);
    }

    public List<Point2D> getSlicePoints() {
        List<Point2D> result = new ArrayList<>();
        double currentAngle = Math.PI / 2;
        for (int i = 0; i < 3; i++) {
            Point2D pointOnCircle = new Point2D(0.0, 0.0);
            double x = center.getX() + getRadius() * Math.cos(currentAngle);
            double y = center.getY() + getRadius() * Math.sin(currentAngle);
            pointOnCircle.setX(x);
            pointOnCircle.setY(y);
            result.add(pointOnCircle);
            currentAngle += Math.PI / 2;
        }
        return result;
    }

    public double getSurfaceArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public void resize(double resizeFactor) {
        if (-resizeFactor >= getRadius()) {
            throw new IllegalArgumentException("you wanted to shrink the circle too much");
        } else {
            surfaceArea = getSurfaceArea() + resizeFactor;
            double newRadius = Math.sqrt(surfaceArea / Math.PI);
            double oldRadius = getRadius();
            point.setX( point.getX() / oldRadius * newRadius);
            point.setY( point.getY() / oldRadius * newRadius);
        }
    }

    public static void main(String[] args) {
        Point2D center = new Point2D(0d, 0d);
        Point2D point = new Point2D(1d, 1d);
        Circle circle = new Circle(center, point);

        System.out.println("radius is " + circle.getRadius());
        System.out.println("points on circle " + circle.getSlicePoints());
        System.out.println("Point " + point);

        System.out.println("SurfaceArea is " + circle.getSurfaceArea());
        System.out.println("-------------------");


        circle.resize(11d);

        System.out.println("radius is " + circle.getRadius());
        System.out.println("SurfaceArea is " + circle.getSurfaceArea());
        System.out.println("Point " + point);
        System.out.println("points on circle " + circle.getSlicePoints());



    }
}
