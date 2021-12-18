package com.example.flappy_bird;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class Bird extends Pane {
    Image image = new Image(new File("src/main/java/com/example/flappy_bird/resources/pngwing.com (1).png").toURI().toString());
    ImageView imageView = new ImageView(image);
    public Point2D velocity;
    Rectangle rectangle;

    public Bird() {
        velocity = new Point2D(0, 0);
        imageView.setFitHeight(35);
        imageView.setFitWidth(35);
        setTranslateX(100);
        setTranslateY(300);
        getChildren().addAll(this.imageView);
    }

    public void moveY(int value) {
        boolean moveDown;
        moveDown = value > 0;
        for (int i = 0; i < Math.abs(value); i++) {
            for (FirstWall w : FlappyBird.firstWalls) {
                if (moveDown) {
                    setTranslateY(getTranslateY() + 2);
                } else {
                    setTranslateY(getTranslateY() - 2);
                }
                return;
            }
        }
        if (getTranslateY() < 0) {
            setTranslateY(0);
        }
        if (getTranslateY() > 580) {
            setTranslateY(580);
        }
        setTranslateY(getTranslateY() + (moveDown? 1:-1));
    }

    public void moveX(int value) {
        for (int i = 0; i < value; i++) {
            setTranslateX(getTranslateX() + 1);
            for (FirstWall wall : FlappyBird.firstWalls) {
                if (this.getBoundsInParent().intersects(wall.getBoundsInParent())) {
                    if (getTranslateX() + 20 == wall.getTranslateX()) {
                        System.exit(1);
                        setTranslateX(getTranslateX() - 1);
                        return;
                    }
                }
                if (getTranslateX() == wall.getTranslateX()) {
                    FlappyBird.score++;
                    return;
                }

            }

        }
    }
    public void jump(){
        velocity = new Point2D(3, -30);
    }
}


