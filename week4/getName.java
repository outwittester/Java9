package com.company;

import java.io.File;
import java.io.IOException;


public class getName {
    public static void main(String[] args) throws IOException {
        String dirname = "/Users/yutong/IdeaProjects/test/src/sample";
        File dir = new File(dirname);
        if (dir.isDirectory()) {
            System.out.println("Directory" + dirname);
            String[] sub = dir.list();
            for (int i = 0; i < sub.length; i++) {
                File f = new File(dirname + "/" + sub[i]);
                if (f.isDirectory()) {
                    System.out.println(sub[i] + "is a directory");
                } else {
                    System.out.println(sub[i] + "is a file");
                }
            }

        } else {
            System.out.println(dirname + "is not a directory");
        }
    }
}


