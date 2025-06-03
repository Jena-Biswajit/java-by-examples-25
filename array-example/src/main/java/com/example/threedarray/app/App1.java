package com.example.threedarray.app;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Slf4j
public class App1 {
    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(App1.class);
        int [][] arr = new int[2][2];
        logger1.info(Arrays.toString(arr));
    }
}
