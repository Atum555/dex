package com.dexproject.util;

import java.util.Objects;
import java.util.Random;

public class Position {
    private int x;
    private int y;

    public Position() {
        this(0, 0);
    }

    public Position(Position position) {
        this();
        this.set(position);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void set(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {
        switch (direction) {
            case UP -> this.y--;
            case DOWN -> this.y++;
            case RIGHT -> this.x++;
            case LEFT -> this.x--;
        }
    }

    public Position add(Position position) {
        return new Position(
                this.x + position.x,
                this.y + position.y
        );
    }

    public Position subtract(Position position) {
        return new Position(
                this.x - position.x,
                this.y - position.y
        );
    }

    public double norm() {
        return Math.sqrt(
                this.x * this.x + this.y * this.y
        );
    }

    public static Position random(Range rangeX, Range rangeY) {
        Random rand = new Random();
        int x = rand.nextInt(rangeX.delta()) + rangeX.start();
        int y = rand.nextInt(rangeY.delta()) + rangeY.start();
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" + x + ", " + y + '}';
    }
}
