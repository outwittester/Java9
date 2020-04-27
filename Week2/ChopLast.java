// ChopLast, chop the address to the last slash

import java.util.*;

public class ChopLast {
    public static void main(String[] args) {
        String address = args[0];
        String output = address.substring(0, address.lastIndexOf("/"));
        System.out.println(output);
    }
}
