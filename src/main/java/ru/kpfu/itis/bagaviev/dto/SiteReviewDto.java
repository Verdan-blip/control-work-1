package ru.kpfu.itis.bagaviev.dto;

public class SiteReviewDto {

    private String text;

    private String userAvatar;

    private String userName;

    private String date;

    private Short starRate;

    public SiteReviewDto(String text, String userAvatar, String userName, String date, Short starRate) {
        this.text = text;
        this.userAvatar = userAvatar;
        this.userName = userName;
        this.date = date;
        this.starRate = starRate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Short getStarRate() {
        return starRate;
    }

    public void setStarRate(Short starRate) {
        this.starRate = starRate;
    }
}
