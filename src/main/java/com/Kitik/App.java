package com.Kitik;

import com.Kitik.view.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        new View().show();
    }


}
