package JavaBean;

import java.util.*;
import java.net.*;
import java.io.*;
/**
 *
 * @author cthoma29
 */
public class PizzaOrderBean extends java.lang.Object implements java.io.Serializable {
    private int regular;
    private int supreme;
    private int vege;
    private double total;
    
    public PizzaOrderBean() { regular = 0; supreme = 0; vege = 0; total = 0;}
    public void setRegular( int value ) { regular += value; }
    public void setSupreme( int value ) { supreme += value; }
    public void setVege( int value ) { vege += value; }
    public int getRegular() { return regular; }
    public int getSupreme() { return supreme; }
    public int getVege() { return vege; }
    public void setTotal(double value) { total += value; }
    public double getTotal() { return total; }
}