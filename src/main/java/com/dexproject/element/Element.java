package com.dexproject.element;

import com.dexproject.util.Direction;
import com.dexproject.util.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Objects;

public abstract class Element {
    private final Position position;

    public Element(Position position) {
        this.position = position;
    }

    public void move(Direction direction) {
        this.position.move(direction);
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }

    public Position getPosition() {
        return new Position(this.position);
    }

    protected abstract TextColor getBackGroundColor();

    protected abstract TextColor getForeGroundColor();

    protected abstract char getFigureChar();

    public void draw(TextGraphics graphics, Position offset) {
        graphics.setBackgroundColor(this.getBackGroundColor());
        graphics.setForegroundColor(this.getForeGroundColor());
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(
                new TerminalPosition(
                        offset.x() + this.position.x(),
                        offset.y() + this.position.y()
                ),
                String.valueOf(this.getFigureChar())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(position, element.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    @Override
    public String toString() {
        return this.getClass().getTypeName() + "{" + position + "}";
    }
}
