package com.wjc.lc.twentytwo.temp;

public class Item {
    public static Item[] listItems (String directory_path){
        return null;
    }
    public static Boolean isItemDirectory (Item item){

        return null;
    }
    public static String printDirectoryPath(Item item){

        return null;
    }

    public static void tree(String path) {
        printTree(path,0);
    }

    private static void printTree(String path, Integer count) {
        Item[] items = listItems(path);
        for (Item item : items) {
            if (isItemDirectory(item)) {
                for (Integer i = 0; i < count; i++) {
                    System.out.print("   ");
                }
                System.out.println(printDirectoryPath(item));
                printTree(printDirectoryPath(item),count+1);
            }else {
                for (Integer i = 0; i < count; i++) {
                    System.out.print("   ");
                }
                System.out.println(printDirectoryPath(item));
            }
        }
    }
}
