package com.dexproject;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.io.IOException;

public class Dex {
    public static void main(String[] args) throws IOException {
        final int TERMINAL_WIDTH = 40;
        final int TERMINAL_HEIGHT = 20;
        final int TERMINAL_FONT_SIZE = 22;

        final TerminalSize TERMINAL_SIZE = new TerminalSize(TERMINAL_WIDTH, TERMINAL_HEIGHT);

        // Create Terminal and Screen
        Screen screen = new DefaultTerminalFactory()
                .setTerminalEmulatorTitle("Dex")
                .setInitialTerminalSize(TERMINAL_SIZE)
                .setTerminalEmulatorFontConfiguration(
                        SwingTerminalFontConfiguration.getDefaultOfSize(TERMINAL_FONT_SIZE)
                )
                .createScreen();

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }
}