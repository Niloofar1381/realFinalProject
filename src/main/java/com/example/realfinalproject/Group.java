package com.example.realfinalproject;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Group {
    @NonNull
    User admin;
    @NonNull
    String groupName;
    @NonNull
    String groupId;
    ArrayList<User>users=new ArrayList<>();
    ArrayList<Boolean>banned=new ArrayList<>();
    ArrayList<GroupMessage>groupMessages=new ArrayList<>();
    String image;

}
