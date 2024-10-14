package com.dexproject;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import javax.swing.*;
import java.io.IOException;

public class Dex {
    public static void main(String[] args) throws IOException {
        Screen screen = new DefaultTerminalFactory().createScreen();
    }
}