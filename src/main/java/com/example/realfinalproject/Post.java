package com.example.realfinalproject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Post {
    String userId;
    String Id;
    String text="";
    ArrayList<String> likeUsersId = new ArrayList<>();
    ArrayList<String> commentsId = new ArrayList<>();
    String image="";

    public Post(String id, String userId , String text, ArrayList<String> likeUsersId, ArrayList<String> commentsId, String image) {

        Id = id;
        this.userId = userId;
        this.text = text;
        this.likeUsersId = likeUsersId;
        this.commentsId = commentsId;
        this.image = image;
    }
    public Post(String userId, String id) {
        this.userId = userId;
        this.Id= id;
    }
}
