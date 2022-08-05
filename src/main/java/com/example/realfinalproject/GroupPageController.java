package com.example.realfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;

public class GroupPageController {
    Manager manager = new Manager();
    Stage stage;
    Scene scene;
    @FXML
    Button back;
    @FXML
    Button send;
    @FXML
    Button forward;
    @FXML
    TextArea fillText;
    @FXML
    ImageView bg;
    @FXML
    ImageView groupProfile;
    @FXML
    ImageView message1Image;
    @FXML
    ImageView message2Image;
    @FXML
    Label groupName;
    @FXML
    Label groupId;
    @FXML
    Text label;
    @FXML
    Label memberNumbers;
    @FXML
    TextField forwardId;
    @FXML
    Label id1;
    @FXML
    Label id2;
    @FXML
    Text text1;
    @FXML
    Text text2;
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Button setting;
    @FXML
    Button edit1;
    @FXML
    Button edit2;
    @FXML
    Button reply1;
    @FXML
    Button reply2;
    @FXML
    CheckBox forward1;
    @FXML
    CheckBox forward2;
    @FXML
    Label forwardLabel;
    @FXML
    CheckBox delete1;
    @FXML
    CheckBox delete2;
    @FXML
    Button delete;
    @FXML
    Label leaveTheGroup;
    @FXML
    ImageView imageInTextArea;
    @FXML
    ImageView emoji1;
    @FXML
    ImageView emoji2;
    @FXML
    Button imageEmoji1;
    @FXML
    Button imageEmoji2;
    @FXML
    Button imageEmoji3;
    @FXML
    Button imageEmoji4;
    public boolean isEdit1=false;
    public boolean isEdit2=false;
    public static Group forwardedGroup=null;
    public static Group group = null;
    public GroupMessage groupMessage1=null;
    public GroupMessage groupMessage2=null;
    public static boolean toGroupPage=false;
    public static boolean goToChatPage=false;
    public static User chatUser;
    boolean isEmoji1=false;
    boolean isEmoji2=false;
    boolean isEmoji3=false;
    boolean isEmoji4=false;
    public void initialize() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        edit1.setVisible(false);
        edit2.setVisible(false);
        reply1.setVisible(false);
        reply2.setVisible(false);
        forward1.setVisible(false);
        forward2.setVisible(false);
        delete1.setVisible(false);
        delete2.setVisible(false);
        ImageView imageView = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        imageEmoji1.setGraphic(imageView);

        ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
        imageView2.setFitHeight(20);
        imageView2.setFitWidth(20);
        imageEmoji2.setGraphic(imageView2);

        ImageView imageView3 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
        imageView3.setFitHeight(20);
        imageView3.setFitWidth(20);
        imageEmoji3.setGraphic(imageView3);

        ImageView imageView4 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
        imageView4.setFitHeight(20);
        imageView4.setFitWidth(20);
        imageEmoji4.setGraphic(imageView4);
        User leftUser = GroupSettingController.user;
        if (leftUser!=null){
            leaveTheGroup.setVisible(true);
            leaveTheGroup.setText(leftUser.getId() + " left the group");
        }
        if (manager.checkLogin().getBackGround()!=null){
            InputStream stream = new FileInputStream(manager.checkLogin().getBackGround());
            Image image = new Image(stream);
            bg.setImage(image);
        }
        if (CreateGroupController.toGroupPage){
            group = CreateGroupController.group;
        }
        if (GroupsPageController.toGroupPage){
            group = GroupsPageController.group;
        }
        if(toGroupPage)
        {
            group=forwardedGroup;
        }
        if(ChatPageController.toGroupPage)
        {
            group=ChatPageController.group;
        }
        if (MainChatsPageController.toGroupPage){
            group = MainChatsPageController.group;
        }
        if (group.getImage()!=null) {
            InputStream stream = new FileInputStream(group.getImage());
            Image image = new Image(stream);
            groupProfile.setImage(image);
        }
        groupName.setText(group.getGroupName());
        groupId.setText(group.getGroupId());
        memberNumbers.setText(Integer.toString(group.getUsers().size() + 1));
        ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\send.png");
        imageView1.setFitHeight(33);
        imageView1.setFitWidth(40);
        send.setGraphic(imageView1);
        if (group.getGroupMessages().size()>=1) {
            groupMessage1 = group.getGroupMessages().get(group.getGroupMessages().size() - 1);
            if(groupMessage1.getEmojiAddress()!=null)
            {
                InputStream stream1 = new FileInputStream(groupMessage1.getEmojiAddress());
                Image image1 = new Image(stream1);
                emoji1.setImage(image1);
                imageInTextArea.setImage(null);
            }
            if (groupMessage1.getSender().getImageAddress()!=null) {
                InputStream stream1 = new FileInputStream(groupMessage1.getSender().getImageAddress());
                Image image1 = new Image(stream1);
                message1Image.setImage(image1);
            }
            if (groupMessage1.getSender().equals(manager.checkLogin())){
                message1Image.setX(512);
                id1.setLayoutX(512);
            }
            id1.setText(groupMessage1.getSender().getId());
            text1.setText(groupMessage1.getText());
            edit1.setVisible(true);
            reply1.setVisible(true);
            forward1.setVisible(true);
            delete1.setVisible(true);
            int k=0;
            for (int i = 0; i < group.getUsers().size(); i++) {
                if(group.getUsers().get(i).equals(manager.checkLogin()))
                {
                    k=i;
                    break;
                }
            }
            if(group.getAdmin().equals(manager.checkLogin()))
            {
                k=-1;
            }
            groupMessage1.getSeen().set(k+1,true);
        }
        if (group.getGroupMessages().size()>=2) {
            groupMessage2 = group.getGroupMessages().get(group.getGroupMessages().size() - 2);
            if(groupMessage2.getEmojiAddress()!=null)
            {
                InputStream stream2 = new FileInputStream(groupMessage2.getEmojiAddress());
                Image image2= new Image(stream2);
                emoji2.setImage(image2);
                imageInTextArea.setImage(null);
            }
            if (groupMessage2.getSender().getImageAddress()!=null) {
                InputStream stream2 = new FileInputStream(groupMessage2.getSender().getImageAddress());
                Image image2 = new Image(stream2);
                message2Image.setImage(image2);
            }
            if (groupMessage2.getSender().equals(manager.checkLogin())) {
                message2Image.setX(512);
                id2.setLayoutX(512);
            }
            id2.setText(groupMessage2.getSender().getId());
            text2.setText(groupMessage2.getText());
            edit2.setVisible(true);
            reply2.setVisible(true);
            forward2.setVisible(true);
            delete2.setVisible(true);
            int k=0;
            for (int i = 0; i < group.getUsers().size(); i++) {
                if(group.getUsers().get(i).equals(manager.checkLogin()))
                {
                    k=i;
                    break;
                }
            }
            if(group.getAdmin().equals(manager.checkLogin()))
            {
                k=-1;
            }
            groupMessage2.getSeen().set(k+1,true);
        }
    }
    public void setEdit1() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if(groupMessage1.getSender().equals(manager.checkLogin())) {
            isEdit1 = true;
            isEdit2 = false;
            fillText.setText(text1.getText());
        }
    }
    public void setEdit2() throws SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if(groupMessage2.getSender().equals(manager.checkLogin())) {
            isEdit2 = true;
            isEdit1 = false;
            fillText.setText(text2.getText());
        }
    }
    public void setReply1() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyGroupMessage(groupMessage1.getId(),fillText.getText());
        initialize();
        fillText.clear();
    }
    public void setReply2() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyGroupMessage(groupMessage2.getId(),fillText.getText());
        initialize();
        fillText.clear();
    }
    public void setSend() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        leaveTheGroup.setVisible(false);
        if(!isEdit1&&!isEdit2) {
            String splitInput[] = new String[5];
            splitInput[0] = "send";
            splitInput[1] = "message";
            splitInput[2] = "to";
            splitInput[3] = "group";
            splitInput[4] = group.getGroupId();
            manager.sendGroupMessage(splitInput, fillText.getText());
            if(imageInTextArea.getImage()!=null)
            {
                GroupMessage groupMessage=Manager.groupMessages.get(Manager.groupMessages.size()-1);
                if(isEmoji1) {
                    groupMessage.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
                }
                if(isEmoji2)
                {
                    groupMessage.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
                }
                if(isEmoji3)
                {
                    groupMessage.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
                }
                if(isEmoji4)
                {
                    groupMessage.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
                }
            }
            fillText.clear();
            initialize();
        }
        if(isEdit1&&!isEdit2)
        {
            manager.editGroupMessage(groupMessage1.getId(),fillText.getText());
            fillText.clear();
            initialize();

        }
        if(!isEdit1&&isEdit2)
        {
            manager.editGroupMessage(groupMessage2.getId(),fillText.getText());
            fillText.clear();
            initialize();

        }
    }
    public void switchToMainPage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root = null;
        if (GroupsPageController.toGroupPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("groupsPage.fxml")));
        }
        if (toGroupPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        if (ChatPageController.toGroupPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        if (CreateGroupController.toGroupPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        }
        if (MainChatsPageController.toGroupPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToGroupSetting(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("groupSettingPage.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setForward(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if(manager.findId(forwardId.getText())!=null)
        {
            String[] splitInput=new String[7];
            splitInput[0]="forward";
            splitInput[1]="groupMessage";
            splitInput[2]="to";
            splitInput[3]="pv";
            if(forward1.isSelected())
            {
                splitInput[6]=groupMessage1.getId();
                splitInput[4]=groupMessage1.groupId;
            }
            if(forward2.isSelected())
            {
                splitInput[6]=groupMessage2.getId();
                splitInput[4]=groupMessage2.groupId;
            }
            splitInput[5]=forwardId.getText();
            label.setText(manager.forwardGroupToPv(splitInput));
            goToChatPage=true;
            PrivateMessagePageController.goToChatPage=false;
            ChatPageController.goToChatPage=false;
            MainChatsPageController.goToChatPage = false;
            chatUser=manager.findId(forwardId.getText());
            System.out.println(chatUser.getId());
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chatPage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(manager.searchGroup(forwardId.getText())!=null)
        {
            String[] splitInput=new String[6];
            splitInput[0]="forward";
            splitInput[1]="groupMessage";
            splitInput[2]="to";
            splitInput[3]="group";
            if(forward1.isSelected())
            {
                splitInput[4]=groupMessage1.getId();
            }
            if(forward2.isSelected())
            {
                splitInput[4]=groupMessage2.getId();
            }
            splitInput[5]=forwardId.getText();
            manager.forwardGroupMessage(splitInput);
            label.setText("message forwarded successfully");
            toGroupPage=true;
            CreateGroupController.toGroupPage=false;
            GroupsPageController.toGroupPage=false;
            ChatPageController.toGroupPage=false;
            MainChatsPageController.toGroupPage = false;
            forwardedGroup=manager.searchGroup(forwardId.getText());
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("groupPage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            label.setText("Id not exists");
        }
    }
    public void setDelete() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (delete1.isSelected()){
            if (groupMessage1.getSender().equals(manager.checkLogin())) {
                manager.deleteGroupMessage(groupMessage1.getId());
                text1.setText("");
                text2.setText("");
                id1.setText("");
                id2.setText("");
                message1Image.setImage(null);
                message2Image.setImage(null);
            }
            delete1.setSelected(false);
        }
        if (delete2.isSelected()){
            if (groupMessage2.getSender().equals(manager.checkLogin())) {
                manager.deleteGroupMessage(groupMessage2.getId());
                text1.setText("");
                text2.setText("");
                id1.setText("");
                id2.setText("");
                message1Image.setImage(null);
                message2Image.setImage(null);
            }
            delete2.setSelected(false);
        }
        initialize();
    }
    public void setImageEmoji1() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=true;
        isEmoji2=false;
        isEmoji3=false;
        isEmoji4=false;
    }
    public void setImageEmoji2() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=true;
        isEmoji3=false;
        isEmoji4=false;
    }
    public void setImageEmoji3() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=false;
        isEmoji3=true;
        isEmoji4=false;
    }
    public void setImageEmoji4() throws FileNotFoundException {
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=false;
        isEmoji3=false;
        isEmoji4=true;
    }
}
