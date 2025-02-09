package com.example;

import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        ArrayList<Drawable> drawables = new ArrayList<>();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                count++;
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String type = parts[0];
                    double size = Double.parseDouble(parts[1]);
                    if(size < 0) {
                        System.out.println("Invalid size value: " + size);
                        System.exit(1);
                    }
                    if (type.equalsIgnoreCase("circle")) {
                        drawables.add(new Circle(size));
                    } else if (type.equalsIgnoreCase("cube")) {
                        drawables.add(new Cube(size));
                    } else {
                        System.out.println("Invalid shape type: " + type);
                        System.out.println("The shape type should be circle or cube");
                        System.exit(1);
                    }
                } else {
                    System.out.println("Invalid input format: " + line);
                    System.out.println("The input should be like that: [circle | cube] ([radius | side] value)");
                    System.exit(1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(count < 2) {
            System.out.println("The minimum number of arguments should be 2");
            System.exit(1);
        }

        double totalArea = 0;
        for (Drawable drawable : drawables) {
            if (drawable instanceof Shape) {
                totalArea += ((Shape) drawable).getArea();
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Total area of all shapes: " + totalArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
