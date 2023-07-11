package org.demre.myglide;

public class ItemImage {
    private final String imageUrl;
    private final String description;
    private final String planetas;

    public ItemImage(String imageUrl, String description, String nombre) {
        this.imageUrl = imageUrl;
        this.description = description;
        this.planetas = nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getPlanetas(){
        return planetas;
    }


}
