package com.test;

import java.io.*;


public class Reverse {
    public static boolean reverseText(String inputFile, String outputFile) {
        FileInputStream fis = null;
        RandomAccessFile raf = null;
        String characterEncoding = "UTF-8";
        try {
            File in = new File(inputFile);
            fis = new FileInputStream(in);
            Reader r = new InputStreamReader(fis, characterEncoding);

            File out = new File(outputFile);
            raf = new RandomAccessFile(out, "rw");
            raf.setLength(in.length());
            char[] buff = new char[1];
            long position = in.length();

            while ((r.read(buff)) > -1) {
                Character c = buff[0];
                String s = c + "";
                byte[] bBuff = s.getBytes(characterEncoding);
                position = position - bBuff.length;
                raf.seek(position);
                raf.write(bBuff);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}