package galamseymonitoring;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;


public class StatsPie {

    public StatsPie(){
        initAndShowGUI();
    }

    public void initAndShowGUI(){


        JFrame frame = new JFrame();
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
            }
        });
    }

    public void initFX(JFXPanel fxPanel){
        System.out.println("I came on");

        Scene scene = null;
        try {
            scene = createScene();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fxPanel.setScene(scene);
    }

    public Scene createScene() throws SQLException{
        System.out.println("I also came on");

        Group root = new Group();
        Scene scene = new Scene(root);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Brown - " + MonitoringIO.db.countRecords(3), MonitoringIO.db.countRecords(3)),
                        new PieChart.Data("Yellow - " + MonitoringIO.db.countRecords(2), MonitoringIO.db.countRecords(2)),
                        new PieChart.Data("Green - " + MonitoringIO.db.countRecords(1), MonitoringIO.db.countRecords(1)));

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Colour Value Statistics");

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }
        root.getChildren().add(chart);
        return (scene);
    }

    public static void main(String[] args) throws InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
