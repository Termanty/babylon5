package com.babylon5.bibtextarchive;

import java.util.HashMap;


    public class Article {

    private String author;
    private String title;
    private String journal;
    private String year;
    private String volume;
    private String number;
    private String pages;
    private String month;
    private String note;
    private String key;
    HashMap<String, String> values;

    public Article(HashMap<String, String> values) {
        this.values = values;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String[] orderTable = {"author", "title", "journal", "year", "volume", "number", "pages", "month", "note", "key"};
        for (String string : orderTable) {
            if(values.containsKey(string)){
                sb.append(string + ": " + values.get(string) + "\n");
            }
        }

        return sb.toString() + "";

    }

}
