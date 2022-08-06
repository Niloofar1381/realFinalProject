package com.example.realfinalproject;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@RequiredArgsConstructor
public class Message {
    @NonNull
    private User sender;
    @NonNull
    private User receiver;
    @NonNull
    private int id;
    @NonNull
    private String text;
    @NonNull
    private LocalDate localDate;
    boolean forwarded=false;
    public String localDateToString;
    private boolean seen = false;
    private String time;
    private String emojiAddress;
    public Message(User sender, String text, User receiver, int id, boolean forwarded, LocalDate localDate,boolean seen,String time,String emojiAddress) {
        this.sender = sender;
        this.text = text;
        this.receiver = receiver;
        this.id = id;
        this.forwarded = forwarded;
        this.localDate = localDate;
        this.seen = seen;
        this.time = time;
        this.emojiAddress = emojiAddress;
    }
}

