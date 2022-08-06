package com.example.realfinalproject;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Post {
    @NonNull
    String userId;
    @NonNull
    String Id;
    String text="";
    ArrayList<String> likeUsersId = new ArrayList<>();
    ArrayList<String> commentsId = new ArrayList<>();
    String image="";
}
