package org.demre.myglide;

public class ItemImagens {
    private String imageUrl;
    private String description;
    private String planetas;

    public ItemImagens(String imageUrl, String description, String nombre) {
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
