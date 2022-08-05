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
import java.util.Objects;

public class commentPageController {
    Manager manager=new Manager();
    Stage stage;
    Scene scene;
    @FXML
    ImageView bg;
    @FXML
    ImageView comment1Image;
    @FXML
    ImageView comment2Image;
    @FXML
    ImageView comment3Image;
    @FXML
    ImageView comment4Image;
    @FXML
    Label comment1;
    @FXML
    Label comment2;
    @FXML
    Label comment3;
    @FXML
    Label comment4;
    @FXML
    Label id1;
    @FXML
    Label id2;
    @FXML
    Label id3;
    @FXML
    Label id4;
    @FXML
    Button back;
    @FXML
    Button goToLeaveCommentPage;
    @FXML
    Button like1;
    @FXML
    Button comment1Button;
    @FXML
    Button like2;
    @FXML
    Button comment2Button;
    @FXML
    Button like3;
    @FXML
    Button comment3Button;
    @FXML
    Button like4;
    @FXML
    Button comment4Button;
    @FXML
    Text text1;
    @FXML
    Text text2;
    @FXML
    Text text3;
    @FXML
    Text text4;
    public static Post commentPost1=null;
    public static Post commentPost2=null;
    public static Post commentPost3=null;
    public static Post commentPost4=null;
    public static Post post1=null;
    public static boolean commentPage=false;
    public void initialize() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        like1.setVisible(false);
        like2.setVisible(false);
        like3.setVisible(false);
        like4.setVisible(false);
        comment1Button.setVisible(false);
        comment2Button.setVisible(false);
        comment3Button.setVisible(false);
        comment4Button.setVisible(false);
        Post post = null;
        if (manager.checkLogin().getBackGround()!=null){
            InputStream stream = new FileInputStream(manager.checkLogin().getBackGround());
            Image image = new Image(stream);
            bg.setImage(image);
        }
        if(PreviousPostsController.prePostPage)
        {
            post=PreviousPostsController.post;
        }
        if (FriendsPostsController.followerPostPage)
        {
            post= FriendsPostsController.post;
        }
        if (MainPageController.mainPage)
        {
            post=MainPageController.post;
        }
        if(commentPageController.commentPage)
        {
            post=post1;
        }
        if(SuggestBusinessPostPageController.suggestBusinessPost)
        {
            post=(Post)SuggestBusinessPostPageController.businessPost;
        }
        assert post != null;
        if(post.commentsId.size()>=1)
        {
            commentPost1=manager.searchPostById(post.commentsId.get(post.commentsId.size()-1));
            comment1.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-1)).getText());
            if(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size()-1)).userId).getImageAddress()!=null)
            {
                InputStream stream = new FileInputStream(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size()-1)).userId).getImageAddress());
                Image image = new Image(stream);
                comment1Image.setImage(image);
            }
            ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
            imageView1.setFitHeight(25);
            imageView1.setFitWidth(30);
            like1.setGraphic(imageView1);
            like1.setVisible(true);
            id1.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-1)).userId);
            ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
            imageView2.setFitHeight(25);
            imageView2.setFitWidth(30);
            comment1Button.setGraphic(imageView2);
            comment1Button.setVisible(true);
        }
        if(post.commentsId.size()>=2)
        {
            commentPost2=manager.searchPostById(post.commentsId.get(post.commentsId.size()-2));
            comment2.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-2)).getText());
            if(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size()-2)).userId).getImageAddress()!=null) {
                InputStream stream = new FileInputStream(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size() - 2)).userId).getImageAddress());
                Image image = new Image(stream);
                comment2Image.setImage(image);
            }
            ImageView imageView1= new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
            imageView1.setFitHeight(25);
            imageView1.setFitWidth(30);
            like2.setGraphic(imageView1);
            like2.setVisible(true);
            id2.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-2)).userId);
            ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
            imageView2.setFitHeight(25);
            imageView2.setFitWidth(30);
            comment2Button.setGraphic(imageView2);
            comment2Button.setVisible(true);
        }
        if(post.commentsId.size()>=3) {
            commentPost3=manager.searchPostById(post.commentsId.get(post.commentsId.size()-1));
            comment3.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-3)).getText());
            if(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size()-3)).userId).getImageAddress()!=null) {
                InputStream stream = new FileInputStream(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size() - 3)).userId).getImageAddress());
                Image image = new Image(stream);
                comment3Image.setImage(image);
            }
            id3.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-3)).userId);
            ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
            imageView1.setFitHeight(25);
            imageView1.setFitWidth(30);
            like3.setGraphic(imageView1);
            like3.setVisible(true);
            ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
            imageView2.setFitHeight(25);
            imageView2.setFitWidth(30);
            comment3Button.setGraphic(imageView2);
            comment3Button.setVisible(true);
        }
        if(post.commentsId.size()>=4)
        {
            commentPost4=manager.searchPostById(post.commentsId.get(post.commentsId.size()-1));
            comment4.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-4)).getText());
            if(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size()-4)).userId).getImageAddress()!=null) {
                InputStream stream = new FileInputStream(manager.findId(manager.searchPostById(post.commentsId.get(post.commentsId.size() - 4)).userId).getImageAddress());
                Image image = new Image(stream);
                comment4Image.setImage(image);
            }
            ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\likeLogo.png");
            imageView1.setFitHeight(25);
            imageView1.setFitWidth(30);
            like4.setGraphic(imageView1);
            like4.setVisible(true);
            id4.setText(manager.searchPostById(post.commentsId.get(post.commentsId.size()-4)).userId);
            ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\commentLogo.png");
            imageView2.setFitHeight(25);
            imageView2.setFitWidth(30);
            comment4Button.setGraphic(imageView2);
            comment4Button.setVisible(true);
        }


    }
    public void switchToLeaveCommentPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("leaveCommentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root = null;
        if (PreviousPostsController.prePostPage){
            root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("previousPostsPage.fxml")));
        }
        else if (MainPageController.mainPage){
            root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        }
        else if (FriendsPostsController.followerPostPage){
            root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        }
        else if(commentPage)
        {
            root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        }
        else if(SuggestBusinessPostPageController.suggestBusinessPost)
        {
            root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        assert root != null;
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLike1() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String[] splitInput=new String[2];
        splitInput[0]="LIKE";
        splitInput[1]=commentPost1.getId();
        if(!commentPost1.getLikeUsersId().contains(manager.checkLogin().getId())) {
            manager.like(splitInput);
            text1.setText("liked successfully" + "\n" + "likes: " + commentPost1.getLikeUsersId().size());
        }
    }
    public void setLike2() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String[] splitInput=new String[2];
        splitInput[0]="LIKE";
        splitInput[1]=commentPost2.getId();
        if(!commentPost2.getLikeUsersId().contains(manager.checkLogin().getId())) {
            manager.like(splitInput);
            text2.setText("liked successfully" + "\n" + "likes: " + commentPost2.getLikeUsersId().size());
        }
    }
    public void setLike3() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String[] splitInput=new String[2];
        splitInput[0]="LIKE";
        splitInput[1]=commentPost3.getId();
        if(!commentPost3.getLikeUsersId().contains(manager.checkLogin().getId())) {
            manager.like(splitInput);
            text3.setText("liked successfully" + "\n" + "likes: " + commentPost3.getLikeUsersId().size());
        }
    }
    public void setLike4() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        String[] splitInput=new String[2];
        splitInput[0]="LIKE";
        splitInput[1]=commentPost4.getId();
        if(!commentPost4.getLikeUsersId().contains(manager.checkLogin().getId())) {
            manager.like(splitInput);
            text4.setText("liked successfully" + "\n" + "likes: " + commentPost4.getLikeUsersId().size());
        }
    }
    public void setComment1(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        commentPage=true;
        PreviousPostsController.prePostPage=false;
        MainPageController.mainPage=false;
        FriendsPostsController.followerPostPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post1=commentPost1;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setComment2(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        commentPage=true;
        PreviousPostsController.prePostPage=false;
        MainPageController.mainPage=false;
        FriendsPostsController.followerPostPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post1=commentPost2;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setComment3(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        commentPage=true;
        PreviousPostsController.prePostPage=false;
        MainPageController.mainPage=false;
        FriendsPostsController.followerPostPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post1=commentPost3;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setComment4(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        commentPage=true;
        PreviousPostsController.prePostPage=false;
        MainPageController.mainPage=false;
        FriendsPostsController.followerPostPage=false;
        SuggestBusinessPostPageController.suggestBusinessPost=false;
        post1=commentPost4;
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("commentPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
