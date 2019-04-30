package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public GridPane gridCellularAutomata;
    public Button rule225;
    public Button rule120;
    public Button rule90;
    public Button rule60;
    public Button rule30;
    public Spinner<Integer> sizeC;
    public Spinner<Integer> iteration;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sizeC.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 500));
        iteration.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 500));
    }

    public void clearGrid(ActionEvent actionEvent) {
        gridCellularAutomata.getChildren().clear();

    }

    public void generateRule30(ActionEvent actionEvent) {

        int rozmiarX =  iteration.getValue();
        int rozmiarY =sizeC.getValue();

        int[][] tab = new int[rozmiarX][rozmiarY];

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                tab[i][j] = 0;

            }
        }

        tab[0][rozmiarY / 2] = 1;


        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                if (j == 0) {
                    if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else if (j == rozmiarY - 1) {
                    if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else {
                    if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                }

                for (int row = 0; row < rozmiarX; row++) {
                    for (int col = 0; col < rozmiarY; col++) {
                        Rectangle square = new Rectangle();
                        Color color;
                        if (tab[row][col] == 0) color = Color.WHITE;
                        else color = Color.BLACK;
                        square.setFill(color);
                        gridCellularAutomata.add(square, col, row);
                        square.widthProperty().bind(gridCellularAutomata.widthProperty().divide(rozmiarY));
                        square.heightProperty().bind(gridCellularAutomata.heightProperty().divide(rozmiarX));

                    }
                }

            }
        }
    }

    public void generateRule60(ActionEvent actionEvent) {
        int rozmiarX =  iteration.getValue();
        int rozmiarY =sizeC.getValue();

        int[][] tab = new int[rozmiarX][rozmiarY];

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                tab[i][j] = 0;

            }
        }

        tab[0][rozmiarY / 2] = 1;

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                if (j == 0) {
                    if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else if (j == rozmiarY - 1) {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                }
            }
        }

        for (int row = 0; row < rozmiarX; row++) {
            for (int col = 0; col < rozmiarY; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if (tab[row][col] == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                gridCellularAutomata.add(square, col, row);
                square.widthProperty().bind(gridCellularAutomata.widthProperty().divide(rozmiarY));
                square.heightProperty().bind(gridCellularAutomata.heightProperty().divide(rozmiarX));

            }
        }


    }



    public void generateRule90(ActionEvent actionEvent) {

        int rozmiarX =  iteration.getValue();
        int rozmiarY =sizeC.getValue();

        int[][] tab = new int[rozmiarX][rozmiarY];

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                tab[i][j] = 0;

            }
        }

        tab[0][rozmiarY / 2] = 1;

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                if (j == 0) {
                    if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else if (j == rozmiarY - 1) {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                }
            }
        }



        for (int row = 0; row < rozmiarX; row++) {
            for (int col = 0; col < rozmiarY; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if (tab[row][col] == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                gridCellularAutomata.add(square, col, row);
                square.widthProperty().bind(gridCellularAutomata.widthProperty().divide(rozmiarY));
                square.heightProperty().bind(gridCellularAutomata.heightProperty().divide(rozmiarX));

            }
        }
    }

    public void generateRule120(ActionEvent actionEvent) {

        int rozmiarX =  iteration.getValue();
        int rozmiarY =sizeC.getValue();

        int[][] tab = new int[rozmiarX][rozmiarY];

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                tab[i][j] = 0;

            }
        }

        tab[0][rozmiarY / 2] = 1;

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                if (j == 0) {
                    if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else if (j == rozmiarY - 1) {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                }
            }
        }


        for (int row = 0; row < rozmiarX; row++) {
            for (int col = 0; col < rozmiarY; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if (tab[row][col] == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                gridCellularAutomata.add(square, col, row);
                square.widthProperty().bind(gridCellularAutomata.widthProperty().divide(rozmiarY));
                square.heightProperty().bind(gridCellularAutomata.heightProperty().divide(rozmiarX));

            }
        }
    }

    public void generateRule225(ActionEvent actionEvent) {

        int rozmiarX =  iteration.getValue();
        int rozmiarY =sizeC.getValue();

        int[][] tab = new int[rozmiarX][rozmiarY];

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                tab[i][j] = 0;

            }
        }

        tab[0][rozmiarY / 2] = 1;

        for (int i = 0; i < rozmiarX; i++) {
            for (int j = 0; j < rozmiarY; j++) {
                if (j == 0) {
                    if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][rozmiarY - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else if (j == rozmiarY - 1) {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][0] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][0] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                } else {
                    if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 1 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 1 && tab[i][j] == 0 && tab[i][j + 1] == 1 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    } else if (tab[i][j - 1] == 0 && tab[i][j] == 0 && tab[i][j + 1] == 0 && i != rozmiarX - 1) {
                        tab[i + 1][j] = 1;
                    }
                }
            }
        }


        for (int row = 0; row < rozmiarX; row++) {
            for (int col = 0; col < rozmiarY; col++) {
                Rectangle square = new Rectangle();
                Color color;
                if (tab[row][col] == 0) color = Color.WHITE;
                else color = Color.BLACK;
                square.setFill(color);
                gridCellularAutomata.add(square, col, row);
                square.widthProperty().bind(gridCellularAutomata.widthProperty().divide(rozmiarY));
                square.heightProperty().bind(gridCellularAutomata.heightProperty().divide(rozmiarX));

            }
        }
    }
}
