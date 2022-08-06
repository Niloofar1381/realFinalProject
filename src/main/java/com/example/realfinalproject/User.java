package com.example.realfinalproject;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @NonNull
    private String id;
    @NonNull
    private String password;
    private boolean entered=false;
    @NonNull
    private String nationalCode;
    @NonNull
    private String businessAccount;
    ArrayList<String>followerIds=new ArrayList<>();
    ArrayList<String>followingIds=new ArrayList<>();
    ArrayList<String>postIds=new ArrayList<>();
    ArrayList<Integer> messageIds=new ArrayList<>();
    ArrayList<String> allFriendIds=new ArrayList<>();
    private String imageAddress;
    private String backGround;

    public void printUserPosts(){
        int n= postIds.size();
        if (n<5){
            for (int i=0;i<n;i++) {
                Manager manager = new Manager();
                Post post = manager.searchPostById(postIds.get(i));
                System.out.println(id+"\n" +post.getText());
                if (post.getCommentsId().size()>=1) {
                    User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                    System.out.println("comment: " + user.getId()
                            +"\n"+manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).getText());
                }
            }
        }
        else{
            for (int i=n-1;i>n-6;i--){
                Manager manager = new Manager();
                Post post = manager.searchPostById(postIds.get(i));
                System.out.println(id+"\n"+post.getText());
                if (post.getCommentsId().size()>=1) {
                    User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                    System.out.println("comment: " + user.getId()
                            +"\n"+manager.searchPostById (post.getCommentsId().get(post.getCommentsId().size() - 1)).getText());
                }
            }
        }
    }
    public void printFollowingsPosts(){
        for (int k=0;k<followingIds.size();k++) {
            Manager manager = new Manager();
            User following = manager.findId(followingIds.get(k));
            int n=following.getPostIds().size();
            if (n<5){
                for (int j=0;j<following.getPostIds().size();j++) {
                    Post post = manager.searchPostById(following.getPostIds().get(j));
                    System.out.println(following.getId()+"\n" + post.getText());
                    if (post.getCommentsId().size()>=1) {
                        User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                        System.out.println("comment: " + user.getId()+"\n"+manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).getText());
                    }
                }
            }
            else{
                for (int i=n-1;i>n-6;i--){
                    Post post = manager.searchPostById(following.getPostIds().get(i));
                    System.out.println(following.getId()+"\n"+post.getText());
                    if (post.getCommentsId().size()>=1) {
                        User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                        System.out.println("comment: " + user.getId()
                                +"\n"+ manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size() - 1)).getText());
                    }
                }
            }
        }
    }
    public void printFollowersPosts(){
        Manager manager = new Manager();
        for (int k=0;k<followerIds.size();k++) {
            User follower = manager.findId(followerIds.get(k));
            int n=follower.getPostIds().size();
            if (n<5){
                for (int j=0;j<follower.postIds.size();j++) {
                    Post post = manager.searchPostById(follower.postIds.get(j));
                    System.out.println(follower.getId()+"\n"+ post.getText());
                    if (post.getCommentsId().size()>=1) {
                        User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                        System.out.println("comment: " + user.getId()+"\n"
                                + manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size() - 1)).getText());
                    }
                }
            }
            else{
                for (int i=n-1;i>n-6;i--){
                    Post post = manager.searchPostById(follower.postIds.get(i));
                    System.out.println(follower.getId()+"\n"+post.getText());
                    if (post.getCommentsId().size()>=1) {
                        User user = manager.findId(manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size()-1)).userId);
                        System.out.println("comment: " + user.getId()
                                +"\n"+manager.searchPostById(post.getCommentsId().get(post.getCommentsId().size() - 1)).getText());
                    }
                }
            }
        }
    }
    public int indexOfMessage(Message message){
        Manager manager = new Manager();
        for (int i = 0; i < messageIds.size(); i++) {
            Message message1 = manager.searchMessage(messageIds.get(i));
            if (message1.equals(message)){
                return i+1;
            }
        }
        return -1;
    }
}