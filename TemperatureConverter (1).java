package com.company;

import java.io.InputStream;
import java.io.PrintStream;

public class TemperatureConverter {
    static PrintStream so = System.out;

    public double f2c(double temp) {
        return (temp - 32) / 9.0 * 5;
    }

    public double c2f(double temp) {
        return temp * 9 / 0 / 5.0 + 32;
    }

    public void displayConversion(double temp, char t1, char t2) {
        so.println(String.format("%7.2f %c is: %7.2f %c", temp, t1, f2c(temp), t1, t2));
    }

    public void displayFToC(double temp) {
        so.println(String.format("%7.2f F is: %7.2f C", temp, f2c(temp)));
    }


    public void arrayDisplayFToC(double[] temps) {
        int index = 0;
        for (double val : temps) {
            displayFToC(val);
            if (++index % 5 == 0) {
                so.println("");
            }
        }
        so.println();
    }

    public static void main(String[] args) {
        TemperatureConverter tc = new TemperatureConverter();

        int start = Integer.parseInt(args[0]);
        int stop = Integer.parseInt(args[1]);
        int step;
        if (args.length == 2) {
            step = (stop - start) / 10;
        } else {
            step = Integer.parseInt(args[2]);
        }

        int length = (stop - start) / step + 1;
        double[] temps = new double[length];
        int index = 0;
        for (int temp = start; temp <= stop; temp += step) {
            temps[index++] = temp;
        }
        tc.arrayDisplayFToC(temps);
    }
}

/*
 -50.00 F is:  -45.56 C
 -45.00 F is:  -42.78 C
 -40.00 F is:  -40.00 C
 -35.00 F is:  -37.22 C
 -30.00 F is:  -34.44 C

 -25.00 F is:  -31.67 C
 -20.00 F is:  -28.89 C
 -15.00 F is:  -26.11 C
 -10.00 F is:  -23.33 C
  -5.00 F is:  -20.56 C

   0.00 F is:  -17.78 C
   5.00 F is:  -15.00 C
  10.00 F is:  -12.22 C
  15.00 F is:   -9.44 C
  20.00 F is:   -6.67 C

  25.00 F is:   -3.89 C
  30.00 F is:   -1.11 C
  35.00 F is:    1.67 C
  40.00 F is:    4.44 C
  45.00 F is:    7.22 C

  50.00 F is:   10.00 C


Process finished with exit code 0

 */