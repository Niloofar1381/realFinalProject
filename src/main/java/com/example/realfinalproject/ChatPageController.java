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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Objects;

public class ChatPageController {
    Manager manager=new Manager();
    Stage stage;
    Scene scene;
    @FXML
    ImageView bg;
    @FXML
    ImageView userProfile;
    @FXML
    Label userId;
    @FXML
    Line line1;
    @FXML
    Text chatText1;
    @FXML
    Text chatText2;
    @FXML
    Text chatText3;
    @FXML
    Text chatText4;
    @FXML
    Text chatText5;
    @FXML
    Line line2;
    @FXML
    TextArea textMessage;
    @FXML
    Button send;
    @FXML
    Button back;
    @FXML
    Button edit1;
    @FXML
    Button edit2;
    @FXML
    Button edit3;
    @FXML
    Button edit4;
    @FXML
    Button edit5;
    @FXML
    Button reply1;
    @FXML
    Button reply2;
    @FXML
    Button reply3;
    @FXML
    Button reply4;
    @FXML
    Button reply5;
    @FXML
    Label label;
    @FXML
    Button forward;
    @FXML
    TextField fillId;
    @FXML
    CheckBox forward1;
    @FXML
    CheckBox forward2;
    @FXML
    CheckBox forward3;
    @FXML
    CheckBox forward4;
    @FXML
    CheckBox forward5;
    @FXML
    CheckBox delete1;
    @FXML
    CheckBox delete2;
    @FXML
    CheckBox delete3;
    @FXML
    CheckBox delete4;
    @FXML
    CheckBox delete5;
    @FXML
    Button deleteMessage;
    @FXML
    Text text;
    @FXML
    Button emoji1;
    @FXML
    Button emoji2;
    @FXML
    Button emoji3;
    @FXML
    Button emoji4;
    @FXML
    ImageView emoji1Image;
    @FXML
    ImageView emoji2Image;
    @FXML
    ImageView emoji3Image;
    @FXML
    ImageView emoji4Image;
    @FXML
    ImageView emoji5Image;
    @FXML
    ImageView imageInTextArea;
    int id1=0,id2=0,id3=0,id4=0,id5=0;
    public User user=manager.checkLogin();
    public static User chatUser=null;
    public static User forwardedChatUser=null;
    public static boolean goToChatPage=false;
    public static boolean toGroupPage=false;
    public static Group group=null;
    public boolean isEmoji1=false;
    public boolean isEmoji2=false;
    public boolean isEmoji3=false;
    public boolean isEmoji4=false;
    public void initialize() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        edit1.setVisible(false);
        edit2.setVisible(false);
        edit3.setVisible(false);
        edit4.setVisible(false);
        edit5.setVisible(false);
        reply1.setVisible(false);
        reply2.setVisible(false);
        reply3.setVisible(false);
        reply4.setVisible(false);
        reply5.setVisible(false);
        forward1.setVisible(false);
        forward2.setVisible(false);
        forward3.setVisible(false);
        forward4.setVisible(false);
        forward5.setVisible(false);
        delete1.setVisible(false);
        delete2.setVisible(false);
        delete3.setVisible(false);
        delete4.setVisible(false);
        delete5.setVisible(false);
        if(PrivateMessagePageController.goToChatPage)
        {
            chatUser=PrivateMessagePageController.chatUser;
        }
        if(GroupPageController.goToChatPage)
        {
            chatUser=GroupPageController.chatUser;
        }
        if(goToChatPage)
        {
            chatUser=forwardedChatUser;
        }
        if (MainChatsPageController.goToChatPage){
            chatUser = MainChatsPageController.chatUser;
        }
        if (manager.checkLogin().getBackGround()!=null){
            InputStream stream = new FileInputStream(manager.checkLogin().getBackGround());
            Image image = new Image(stream);
            bg.setImage(image);
        }
        ImageView imageView1 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\send.png");
        imageView1.setFitHeight(35);
        imageView1.setFitWidth(40);
        send.setGraphic(imageView1);
        //set emoji
        ImageView imageView = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);
        emoji1.setGraphic(imageView);

        ImageView imageView2 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
        imageView2.setFitHeight(20);
        imageView2.setFitWidth(20);
        emoji2.setGraphic(imageView2);

        ImageView imageView3 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
        imageView3.setFitHeight(20);
        imageView3.setFitWidth(20);
        emoji3.setGraphic(imageView3);

        ImageView imageView4 = new ImageView("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
        imageView4.setFitHeight(20);
        imageView4.setFitWidth(20);
        emoji4.setGraphic(imageView4);
        boolean block = false;
        for (int i = 0; i < Manager.blocks.size(); i++) {
            if (Manager.blocks.get(i).getBlocker().equals(chatUser) && Manager.blocks.get(i).getBlocked().equals(manager.checkLogin())){
                block = true;
                break;
            }
        }
        if (!block) {
            if(chatUser.getImageAddress()!=null) {
                InputStream stream = new FileInputStream(chatUser.getImageAddress());
                Image image = new Image(stream);
                userProfile.setImage(image);
            }
        }
        userId.setText(chatUser.getId());
        int k=0;
        for(int i=Manager.messages.size()-1;i>=0;i--)
        {
            if((Manager.messages.get(i).getSender().equals(user)&&Manager.messages.get(i).getReceiver().equals(chatUser))||
                    (Manager.messages.get(i).getReceiver().equals(user)&&Manager.messages.get(i).getSender().equals(chatUser)))
            {
                k++;
                if(k<=5) {
                    if (k == 1) {
                        chatText1.setText(Manager.messages.get(i).getSender().getId() + ": " + Manager.messages.get(i).getText());
                        id1=Manager.messages.get(i).getId();
                        if (Manager.messages.get(i).getEmojiAddress()!=null){
                            InputStream stream = new FileInputStream(Manager.messages.get(i).getEmojiAddress());
                            Image image = new Image(stream);
                            emoji1Image.setImage(image);
                            imageInTextArea.setImage(null);
                        }
                        if (manager.checkLogin().equals(Manager.messages.get(i).getSender())) {
                            edit1.setVisible(true);
                        }
                        reply1.setVisible(true);
                        forward1.setVisible(true);
                        delete1.setVisible(true);
                        if(Manager.messages.get(i).getSender().equals(chatUser))
                        {
                            chatText1.setLayoutX(0);
                            Manager.messages.get(i).setSeen(true);

                        }
                        if(Manager.messages.get(i).getSender().equals(user))
                        {
                            chatText1.setLayoutX(155);
                        }
                    }
                    if (k == 2) {
                        chatText2.setText(Manager.messages.get(i).getSender().getId() + ": " + Manager.messages.get(i).getText());
                        id2=Manager.messages.get(i).getId();
                        if (Manager.messages.get(i).getEmojiAddress()!=null){
                            InputStream stream = new FileInputStream(Manager.messages.get(i).getEmojiAddress());
                            Image image = new Image(stream);
                            emoji2Image.setImage(image);
                            imageInTextArea.setImage(null);
                        }
                        if (manager.checkLogin().equals(Manager.messages.get(i).getSender())) {
                           edit2.setVisible(true);
                        }
                        reply2.setVisible(true);
                        forward2.setVisible(true);
                        delete2.setVisible(true);
                        if(Manager.messages.get(i).getSender().equals(chatUser))
                        {
                            chatText2.setLayoutX(0);
                            Manager.messages.get(i).setSeen(true);
                        }
                        if(Manager.messages.get(i).getSender().equals(user))
                        {
                            chatText2.setLayoutX(155);
                        }
                    }
                    if (k == 3) {
                        chatText3.setText(Manager.messages.get(i).getSender().getId()+ ": "+Manager.messages.get(i).getText());
                        id3=Manager.messages.get(i).getId();
                        if (Manager.messages.get(i).getEmojiAddress()!=null){
                            InputStream stream = new FileInputStream(Manager.messages.get(i).getEmojiAddress());
                            Image image = new Image(stream);
                            emoji3Image.setImage(image);
                            imageInTextArea.setImage(null);
                        }
                        if (manager.checkLogin().equals(Manager.messages.get(i).getSender())) {
                            edit3.setVisible(true);
                        }
                        reply3.setVisible(true);
                        forward3.setVisible(true);
                        delete3.setVisible(true);
                        if(Manager.messages.get(i).getSender().equals(chatUser))
                        {
                            chatText3.setLayoutX(0);
                            Manager.messages.get(i).setSeen(true);
                        }
                        if(Manager.messages.get(i).getSender().equals(user))
                        {
                            chatText3.setLayoutX(155);
                        }
                    }
                    if(k==4){
                        chatText4.setText(Manager.messages.get(i).getSender().getId()+": "+Manager.messages.get(i).getText());
                        id4=Manager.messages.get(i).getId();
                        if (Manager.messages.get(i).getEmojiAddress()!=null){
                            InputStream stream = new FileInputStream(Manager.messages.get(i).getEmojiAddress());
                            Image image = new Image(stream);
                            emoji4Image.setImage(image);
                            imageInTextArea.setImage(null);
                        }
                        if (manager.checkLogin().equals(Manager.messages.get(i).getSender())) {
                            edit4.setVisible(true);
                        }
                        reply4.setVisible(true);
                        forward4.setVisible(true);
                        delete4.setVisible(true);
                        if(Manager.messages.get(i).getSender().equals(chatUser))
                        {
                            chatText4.setLayoutX(0);
                            Manager.messages.get(i).setSeen(true);
                        }
                        if(Manager.messages.get(i).getSender().equals(user))
                        {
                            chatText4.setLayoutX(155);

                        }
                    }
                    if(k==5){
                        chatText5.setText(Manager.messages.get(i).getSender().getId()+": "+Manager.messages.get(i).getText());
                        id5=Manager.messages.get(i).getId();
                        if (Manager.messages.get(i).getEmojiAddress()!=null){
                            InputStream stream = new FileInputStream(Manager.messages.get(i).getEmojiAddress());
                            Image image = new Image(stream);
                            emoji5Image.setImage(image);
                            imageInTextArea.setImage(null);
                        }
                        if (manager.checkLogin().equals(Manager.messages.get(i).getSender())) {
                          edit5.setVisible(true);
                        }
                        reply5.setVisible(true);
                        forward5.setVisible(true);
                        delete5.setVisible(true);
                        if(Manager.messages.get(i).getSender().equals(chatUser))
                        {
                            chatText5.setLayoutX(0);
                            Manager.messages.get(i).setSeen(true);
                        }
                        if(Manager.messages.get(i).getSender().equals(user))
                        {
                            chatText5.setLayoutX(155);
                        }
                    }
                }
            }
        }
    }
    public void goToPrivateMessagePage(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Parent root = null;
        if (PrivateMessagePageController.goToChatPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("privateMessagePage.fxml")));
        }
        if (goToChatPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        if (GroupPageController.goToChatPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        if (MainChatsPageController.goToChatPage) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainChatsPage.fxml")));
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void send() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.startPrivateMessage(user,chatUser,textMessage.getText());
        if (imageInTextArea.getImage()!=null) {
            Message message = Manager.messages.get(Manager.messages.size() - 1);
            if(isEmoji1)
            {
                message.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
            }
            if(isEmoji2)
            {
                message.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
            }
            if(isEmoji3)
            {
                message.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
            }
            if(isEmoji4)
            {
                message.setEmojiAddress("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
            }
        }
        initialize();
        textMessage.clear();

    }
    public void setEdit1() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Message message = manager.searchMessage(id1);
        if (!message.forwarded) {
            manager.editMessage(id1, textMessage.getText());
            initialize();
        }
        textMessage.clear();
    }
    public void setEdit2() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Message message = manager.searchMessage(id2);
        if (!message.forwarded) {
            manager.editMessage(id2, textMessage.getText());
            initialize();
        }
        textMessage.clear();
    }
    public void setEdit3() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Message message = manager.searchMessage(id3);
        if (!message.forwarded) {
            manager.editMessage(id3, textMessage.getText());
            initialize();
        }
        textMessage.clear();
    }
    public void setEdit4() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Message message = manager.searchMessage(id4);
        if (!message.forwarded) {
            manager.editMessage(id4, textMessage.getText());
            initialize();
        }
        textMessage.clear();
    }
    public void setEdit5() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        Message message = manager.searchMessage(id5);
        if (!message.forwarded) {
            manager.editMessage(id5, textMessage.getText());
            initialize();
        }
        textMessage.clear();
    }
    public void setReply1() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyMessage(id1, textMessage.getText());
        initialize();
        textMessage.clear();
    }
    public void setReply2() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyMessage(id2, textMessage.getText());
        initialize();
        textMessage.clear();
    }
    public void setReply3() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyMessage(id3, textMessage.getText());
        initialize();
        textMessage.clear();
    }
    public void setReply4() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyMessage(id4, textMessage.getText());
        initialize();
        textMessage.clear();
    }
    public void setReply5() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        manager.replyMessage(id5, textMessage.getText());
        initialize();
        textMessage.clear();
    }
    public void setForward(ActionEvent event) throws SQLException, IOException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        int messageId=0;
        if (forward1.isSelected()){
            messageId = id1;
        }
        if (forward2.isSelected()){
            messageId = id2;
        }
        if (forward3.isSelected()){
            messageId = id3;
        }
        if (forward4.isSelected()){
            messageId = id4;
        }
        if (forward5.isSelected()){
            messageId = id5;
        }
        if(manager.findId(fillId.getText())!=null) {
            manager.forwardMessage(fillId.getText(), messageId);
            goToChatPage=true;
            PrivateMessagePageController.goToChatPage=false;
            GroupPageController.goToChatPage=false;
            MainChatsPageController.goToChatPage = false;
            forwardedChatUser=manager.findId(fillId.getText());
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chatPage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else if(manager.searchGroup(fillId.getText())!=null)
        {
            String[] splitInput=new String[6];
            splitInput[0]="forward";
            splitInput[1]="ordinaryMessage";
            splitInput[2]="to";
            splitInput[3]="group";
            splitInput[4]=fillId.getText();
            splitInput[5]=Integer.toString(messageId);
            manager.forwardPvToGroup(splitInput);
            toGroupPage=true;
            GroupsPageController.toGroupPage=false;
            GroupPageController.toGroupPage=false;
            CreateGroupController.toGroupPage=false;
            MainChatsPageController.toGroupPage = false;
            group=manager.searchGroup(fillId.getText());
            Parent root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("groupPage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else
        {
            text.setText("invalid id");
        }
    }
    public void setDeleteMessage() throws SQLException, FileNotFoundException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        if (delete1.isSelected()){
            if (manager.searchMessage(id1).getSender().equals(manager.checkLogin())) {
                manager.deleteMessage(id1);
                chatText1.setText("");
                chatText2.setText("");
                chatText3.setText("");
                chatText4.setText("");
                chatText5.setText("");
            }
            delete1.setSelected(false);
        }
        if (delete2.isSelected()){
            if (manager.searchMessage(id2).getSender().equals(manager.checkLogin())) {
                manager.deleteMessage(id2);
                chatText1.setText("");
                chatText2.setText("");
                chatText3.setText("");
                chatText4.setText("");
                chatText5.setText("");
            }
            delete2.setSelected(false);
        }
        if (delete3.isSelected()){
            if (manager.searchMessage(id3).getSender().equals(manager.checkLogin())) {
                manager.deleteMessage(id3);
                chatText1.setText("");
                chatText2.setText("");
                chatText3.setText("");
                chatText4.setText("");
                chatText5.setText("");
            }
            delete3.setSelected(false);
        }
        if (delete4.isSelected()){
            if (manager.searchMessage(id4).getSender().equals(manager.checkLogin())) {
                manager.deleteMessage(id4);
                chatText1.setText("");
                chatText2.setText("");
                chatText3.setText("");
                chatText4.setText("");
                chatText5.setText("");
            }
            delete4.setSelected(false);
        }
        if (delete5.isSelected()){
            if (manager.searchMessage(id5).getSender().equals(manager.checkLogin())) {
                manager.deleteMessage(id5);
                chatText1.setText("");
                chatText2.setText("");
                chatText3.setText("");
                chatText4.setText("");
                chatText5.setText("");
            }
            delete5.setSelected(false);
        }
        initialize();
    }
    public void setEmoji1() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji1.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=true;
        isEmoji2=false;
        isEmoji3=false;
        isEmoji4=false;
    }
    public void setEmoji2() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji2.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=true;
        isEmoji3=false;
        isEmoji4=false;
    }
    public void setEmoji3() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji3.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=false;
        isEmoji3=true;
        isEmoji4=false;
    }
    public void setEmoji4() throws FileNotFoundException, SQLException {
        SetArrayLists setArrayLists = new SetArrayLists();
        setArrayLists.setAllArrayLists();
        InputStream stream = new FileInputStream("C:\\Users\\APPLE\\Desktop\\posts\\emoji4.png");
        Image image = new Image(stream);
        imageInTextArea.setImage(image);
        isEmoji1=false;
        isEmoji2=false;
        isEmoji3=false;
        isEmoji4=true;
    }
}
