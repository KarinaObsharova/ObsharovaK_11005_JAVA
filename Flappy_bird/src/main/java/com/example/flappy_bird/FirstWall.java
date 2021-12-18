package com.example.flappy_bird;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.File;

public class FirstWall extends Pane {
    Rectangle rectangle;
    public int height;

    Image imageOfWall = new Image(new File("src/main/java/com/example/flappy_bird/resources/wall.png").toURI().toString());
    ImageView viewOfWall = new ImageView(imageOfWall);
    public FirstWall(int height, boolean flag){
        this.height = height;
        if (flag) {
            viewOfWall.setRotate(180);
        }
        rectangle = new Rectangle(50, height);
        viewOfWall.setFitHeight(height);
        viewOfWall.setFitWidth(50);

        getChildren().add(viewOfWall);
    }
}
