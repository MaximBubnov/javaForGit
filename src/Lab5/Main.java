package Lab5;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Main extends Application {

    private PerspectiveCamera camera;
    private final double cameraModifier = 50.0;
    private final double cameraQuantity = 10.0;
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    private double mouseXold = 0;
    private double mouseYold = 0;
    private final double cameraYLimit = 15;
    private final double rotateModifier = 25;


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Sphere sphere = new Sphere(100);
        PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.GREENYELLOW);
        blueMaterial.setSpecularColor(Color.GREENYELLOW);
        sphere.setMaterial(blueMaterial);

        Camera camera = new PerspectiveCamera(true);
        camera.setFarClip(50000.0);
        camera.setTranslateZ(-1000);

        sphere.setRotationAxis(Rotate.X_AXIS);
        sphere.setRotate(45);

        Group group = new Group();
        group.getChildren().addAll(sphere);
        Scene scene = new Scene(group, 400, 300);
        scene.setFill(Color.GREY);
        scene.setCamera(camera);

        //вешаем обработчик события "клик мыши"
       /* scene.setOnMouseClicked(event -> {
            Node picked = event.getPickResult().getIntersectedNode();
            //если обьект не равен нулю - будем увеливать его в два раза
            if(null !=picked) {
                double scalar = 2;
                //если он уже увелечин, то будем уменьшать (делать изначального размера)
                if(picked.getScaleX() > 1)
                    scalar = 1;
                picked.setScaleX(scalar);
                picked.setScaleY(scalar);
                picked.setScaleZ(scalar);
            }
        });*/

        //обработчик события клавиш изменения по коориднатам
        scene.setOnKeyPressed(event -> {
            double change = cameraQuantity;
            if(event.isShiftDown()) {
                change = cameraModifier;
            }
            KeyCode keyCode = event.getCode();
            if(keyCode == KeyCode.W) {
                camera.setTranslateZ(camera.getTranslateZ() + change);
            }
            if(keyCode == KeyCode.S) {
                camera.setTranslateZ(camera.getTranslateZ() - change);
            }
            if(keyCode == KeyCode.A) {
                camera.setTranslateX(camera.getTranslateX() - change);
            }
            if(keyCode == KeyCode.D) {
                camera.setTranslateX(camera.getTranslateX() + change);
            }
        });

        Rotate xRotate = new Rotate(0,0,0,0, Rotate.X_AXIS);
        Rotate yRotate = new Rotate(0,0,0,0, Rotate.Y_AXIS);
        camera.getTransforms().addAll(xRotate, yRotate);
        //хендлер на события мышки
        scene.addEventHandler(MouseEvent.ANY, event -> {
            if (event.getEventType() == MouseEvent.MOUSE_PRESSED ||
                    event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                double mouseXnew = event.getSceneX();
                double mouseYnew = event.getSceneY();

                if(event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                    double pitchRotate = xRotate.getAngle() + (mouseYnew - mouseYold) / rotateModifier;
                    pitchRotate = pitchRotate > cameraYLimit ? cameraYLimit : pitchRotate;
                    pitchRotate = pitchRotate < -cameraYLimit ? -cameraYLimit : pitchRotate;
                    xRotate.setAngle(pitchRotate);
                    double yawRotate = yRotate.getAngle() - (mouseXnew - mouseXold) / rotateModifier;
                    yRotate.setAngle(yawRotate);
                }
                mouseXold = mouseXnew;
                mouseYold = mouseYnew;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
