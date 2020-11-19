package com.campos.jit.models;

public class Enterprise {

    private String name;
    private String url_image;

    public Enterprise(String name, String url_image) {
        this.name = name;
        this.url_image = url_image;
    }

    public String getName() {
        return name;
    }

    public String getUrl_image() {
        return url_image;
    }
}
