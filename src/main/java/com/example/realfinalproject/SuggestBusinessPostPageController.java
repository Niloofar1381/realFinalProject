package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class SuggestBusinessPostPageController {
    Manager manager = new Manager();
    Stage stage;
    Scene scene;
    @FXML
    ImageView bg;
    @FXML
    ImageView image;
    @FXML
    Button like;
    @FXML
    Button comment;
    @FXML
    Button back;
    @FXML
    Text text;
    @FXML
    Label label;
    @FXML
    ImageView profile;
    @FXML
    Label id;
    @FXML
    Text information;
    public static BusinessPost businessPost = null;
    public static boolean suggestBusinessPost = false;
    public void initialize() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (manager.checkLogin().getBackGround()!=null){
            InputStream stream = new FileInputStream(manager.checkLogin().getBackGround());
            Image image = new Image(stream);
            bg.setImage(image);
        }
        businessPost = manager.suggestBusinessPost();
        if (businessPost!=null){
            InputStream stream = new FileInputStream(businessPost.getImage());
            Image image1 = new Image(stream);
            image.setImage(image1);
            text.setText(businessPost.getText());
            ImageView imageView1 = new ImageView("C:\\Users\\ernika\\Desktop\\posts\\likeLogo.png");
            imageView1.setFitHeight(25);
            imageView1.setFitWidth(30);
            like.setGraphic(imageView1);
            ImageView imageView2 = new ImageView("C:\\Users\\ernika\\Desktop\\posts\\commentLogo.png");
            imageView2.setFitHeight(25);
            imageView2.setFitWidth(30);
            comment.setGraphic(imageView2);
            businessPost.getViewers().add(manager.checkLogin().getId());
            businessPost.views.put(manager.checkLogin(), LocalDate.now());
            businessPost.viewLocalDatesForTable.add(LocalDate.now());
            businessPost.viewUsersForTable.add(manager.checkLogin().getId());
            if(manager.findId(businessPost.userId).getImageAddress()!=null)
            {
                InputStream stream1 = new FileInputStream(manager.findId(businessPost.userId).getImageAddress());
                Image image = new Image(stream1);
                profile.setImage(image);
            }
            id.setText(manager.findId(businessPost.userId).getId());
            Post post=(Post) businessPost;
            information.setText("likes: "+post.getLikeUsersId().size()+"\n"+"views: "+businessPost.getViewers().size());
        }
        else{
            comment.setVisible(false);
            like.setVisible(false);
        }
    }
    public void setLike() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String[] splitInput = new String[2];
        splitInput[0] = "LIKE";
        splitInput[1] = businessPost.getId();
        if(!businessPost.getLikeUsersId().contains(manager.checkLogin().getId())) {
            manager.like(splitInput);
            label.setText("liked successfully");
            Post post=(Post) businessPost;
            information.setText("likes: "+post.getLikeUsersId().size()+"\n"+"views: "+businessPost.getViewers().size());
        }
    }
    public void setComment(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        suggestBusinessPost = true;
        MainPageController.mainPage=false;
        commentPageController.commentPage=false;
        PreviousPostsController.prePostPage=false;
        FriendsPostsController.followerPostPage=false;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
