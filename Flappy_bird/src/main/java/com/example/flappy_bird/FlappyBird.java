package com.example.flappy_bird;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends Application {
    public static Pane appRoot = new Pane();
    public static Pane gameRoot = new Pane();
    Image background = new Image(new File("src/main/java/com/example/flappy_bird/resources/46888871-624a3900-ce7f-11e8-808e-99fd90c8a3f4.png").toURI().toString());
    public static ArrayList<FirstWall> firstWalls = new ArrayList<>();
    Bird bird = new Bird();
    public static int score = 0;
    public Label scoreLabel = new Label(Integer.toString(score));

    public Parent createContent(){
        gameRoot.setPrefSize(600, 600);
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(600);
        backgroundView.setFitHeight(600);
        appRoot.getChildren().add(backgroundView);
        for (int i = 0; i < 100; i++) {
            int enter = (int) (Math.random()*100+50); //wall 50-150
            int height = new Random().nextInt(600-enter); // height wall
            FirstWall wall = new FirstWall(height, true);
            wall.setTranslateX(i*350 + 600);
            wall.setTranslateY(0);
            firstWalls.add(wall);

            FirstWall wall2 = new FirstWall(600-enter-height, false);
            wall2.setTranslateX(i*350 + 600);
            wall2.setTranslateY(height+enter);
            firstWalls.add(wall2);

            gameRoot.getChildren().addAll(wall, wall2);
        }

        gameRoot.getChildren().add(bird);
        appRoot.getChildren().addAll(gameRoot, scoreLabel);
        return appRoot;
    }

    public void update(){
        if(bird.velocity.getY() < 5){
            bird.velocity = bird.velocity.add(0,1);
        }
        bird.moveX((int)bird.velocity.getX());
        bird.moveY((int)bird.velocity.getY());
        scoreLabel.setText(Integer.toString(score));

        bird.translateXProperty().addListener((obs,old, newValue) ->{
            int offset = newValue.intValue();
            if(offset > 200)gameRoot.setLayoutX(-(offset-200));
        });
        if (score == 100) {
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(createContent());
        scene.setOnMouseClicked(event -> bird.jump());
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };
        timer.start();
    }
}
