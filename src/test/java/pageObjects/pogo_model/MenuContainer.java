package pageObjects.pogo_model;

import java.util.ArrayList;

public class MenuContainer {

    public Menu menu;


    public static class Menu {
        public String id;
        public String value;
        public Popup popup;
    }

    public static class Popup {
        public ArrayList<Menuitem> menuitem;
    }

    public static class Menuitem {
        public String value;
        public String onclick;
    }
}

