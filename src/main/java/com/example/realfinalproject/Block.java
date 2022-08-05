package com.example.realfinalproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Block {
    User blocker;
    User blocked;
}
