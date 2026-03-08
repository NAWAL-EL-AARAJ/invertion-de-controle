package net.nawal.pres;

import java.applet.AppletContext;

public class PresSpringXML {
    public static void main(String[] args) {
        AppletContext springContext=
                new ClassPathXmlApplicationContext("config.xml")

    }
}
