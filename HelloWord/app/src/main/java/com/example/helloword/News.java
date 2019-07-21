package com.example.helloword;

public class News {
    String newsID;
    String content;
    String createDate;
    String title;
    String type;
    String urlImage;
    String description;

    public News(String newsID, String content, String createDate, String title, String type, String urlImage, String description) {
        this.newsID = newsID;
        this.content = content;
        this.createDate = createDate;
        this.title = title;
        this.type = type;
        this.urlImage = urlImage;
        this.description = description;
    }

    public String getNewsID() {
        return newsID;
    }

    public void setNewsID(String newsID) {
        this.newsID = newsID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
