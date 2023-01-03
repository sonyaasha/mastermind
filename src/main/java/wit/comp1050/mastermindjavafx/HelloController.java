package wit.comp1050.mastermindjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

//import org.apache.commons;


public class HelloController {
    @FXML
    private Label makeYourGuessText;
    private Game theGame;

    @FXML private AnchorPane apMain;
    private List<String> userGuessClick = new ArrayList<String>();
    private List<RectangleClass> guessRectanglesList = new ArrayList<RectangleClass>();

    private CircleRows circleRows;
    private CircleCells circleCells;

    private int clickCount;
    int cellIdx = 0;
    private int[] secretSequence;
    private String[] feedbackArray;

    private int theLevel;
    private int cellsInOneRow = 0;
    private int theGuessAmount = 0;
    private int lineNumber;

    private AmountColorsInGame colorInGame;

    private boolean isCheck = false;
    private boolean isWinner = false;
    private boolean levelChosen = false;
    private List<Button> levelButtonList;
    private Button theCheckButton;
    private Button theRestartButton;
    private Button theHelpButton;
    private List<Rectangle> mainRectanglesList;
    private List<Rectangle> smallSquares;
    private List<Circle> smallCircleList;
    private List<Circle> theColorsList;
    private Rectangle barWithColorsOnRight;
    private Rectangle screen;
    private Button closeButton;
    private Label welcome;
    private TextArea textArea;

    private void readConfiguration(){

        /**
         System.out.println("-- readConfiguration --");
         // Configurations configurations = new Configurations();
         try
         {
         File propertiesFile = new File("wit/comp1050/mastermindjavafx/mmind.properties");
         Parameters params = new Parameters();
         FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
         new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
         .configure(params.fileBased()
         .setFile(propertiesFile));
         Configuration config = builder.getConfiguration();
         String level = config.getString("level");
         }
         catch (Exception cex)
         {
         System.out.println(cex.getStackTrace());
         }

         **/
    }

    @FXML
    public void initialize(){
        System.out.println("Initialize");
        if(barWithColorsOnRight != null){
            barWithColorsOnRight.setVisible(false);
        }
        drawLevelButtons();
        drawHelpButton();
        makeYourGuessText.setText("Please Choose Level");
    }

    public void initParams(){
        lineNumber = 0;
        cellIdx = 0;
        clickCount = 0;
        isWinner = false;
        isCheck = false;
        cellsInOneRow = 0;
        theGuessAmount = 0;
        userGuessClick = new ArrayList<String>();
        guessRectanglesList = new ArrayList<RectangleClass>();
        colorInGame = new AmountColorsInGame();
        theColorsList = new ArrayList<Circle>();

    }

    @FXML
    protected void onNoviceLevelClick(MouseEvent mouseEvent){
        drawRestartButton();

        for(int buttonNum = 0; buttonNum < levelButtonList.size(); buttonNum++){
            levelButtonList.get(buttonNum).setVisible(false);
        }

        makeYourGuessText.setText("Make Your Guess!");

        theLevel = 5;
        theGame = new Game(theLevel);

        //setting how many circles in a row
        cellsInOneRow = theGame.getGameCodeSize();
        //setting rectangles based on how many guesses
        theGuessAmount = theGame.getTheGuessAmount();

        //generating secret sequence
        secretSequence = theGame.theSecretSequence();

        System.out.println("theSecretSequence: " + Arrays.toString(secretSequence));
        clickCount = 0;

        drawStageBarsBasedOnLevel();
        drawMainRectangles();
        drawCircles();
        drawSquaresAndSmallCircles();
        drawColoredOptions();
    }

    @FXML
    protected void onBeginnerLevelClick(MouseEvent mouseEvent){
        drawRestartButton();

        for(int buttonNum = 0; buttonNum < levelButtonList.size(); buttonNum++){
            levelButtonList.get(buttonNum).setVisible(false);
        }

        makeYourGuessText.setText("Make Your Guess!");

        theLevel = 6;
        theGame = new Game(theLevel);

        //setting how many circles in a row
        cellsInOneRow = theGame.getGameCodeSize();
        //setting rectangles based on how many guesses
        theGuessAmount = theGame.getTheGuessAmount();

        //generating secret sequence
        secretSequence = theGame.theSecretSequence();

        System.out.println(Arrays.toString(secretSequence));
        clickCount = 0;

        drawStageBarsBasedOnLevel();
        drawMainRectangles();
        drawCircles();
        drawSquaresAndSmallCircles();
        drawColoredOptions();
    }

    @FXML
    protected void onIntermediateLevelClick(MouseEvent mouseEvent){
        drawRestartButton();

        for(int buttonNum = 0; buttonNum < levelButtonList.size(); buttonNum++){
            levelButtonList.get(buttonNum).setVisible(false);
        }

        makeYourGuessText.setText("Make Your Guess!");

        theLevel = 7;
        theGame = new Game(theLevel);

        //setting how many circles in a row
        cellsInOneRow = theGame.getGameCodeSize();
        //setting rectangles based on how many guesses
        theGuessAmount = theGame.getTheGuessAmount();

        //generating secret sequence
        secretSequence = theGame.theSecretSequence();

        System.out.println(Arrays.toString(secretSequence));
        clickCount = 0;

        drawStageBarsBasedOnLevel();
        drawMainRectangles();
        drawCircles();
        drawSquaresAndSmallCircles();
        drawColoredOptions();
    }

    @FXML
    protected void onExpertLevelClick(MouseEvent mouseEvent){
        drawRestartButton();

        for(int buttonNum = 0; buttonNum < levelButtonList.size(); buttonNum++){
            levelButtonList.get(buttonNum).setVisible(false);
        }

        makeYourGuessText.setText("Make Your Guess!");

        theLevel = 8;
        theGame = new Game(theLevel);

        //setting how many circles in a row
        cellsInOneRow = theGame.getGameCodeSize();
        //setting rectangles based on how many guesses
        theGuessAmount = theGame.getTheGuessAmount();

        //generating secret sequence
        secretSequence = theGame.theSecretSequence();

        System.out.println(Arrays.toString(secretSequence));
        clickCount = 0;

        drawStageBarsBasedOnLevel();
        drawMainRectangles();
        drawCircles();
        drawSquaresAndSmallCircles();
        drawColoredOptions();
    }

    @FXML
    protected void onCheckButtonClick(MouseEvent mouseEvent){
        theCheckButton.setVisible(false);

        isCheck = false;

        if(isWinner){
            makeYourGuessText.setText("Game is Over");
            return;
        }

        String guessValue = "";
        for (String s : userGuessClick) {
            guessValue += s;
        }
        System.out.println("GuessValue: " + guessValue);
        if(guessValue == null){
            throw new IllegalArgumentException();
        } else{
            this.theGame.stringToIntConvert(guessValue);
        }
        feedbackArray = this.theGame.feedbackOnUserGuess();

        lineNumber = cellIdx-1;
        System.out.println("You have " + (theGuessAmount-1-lineNumber) + " guesses left!");
        makeYourGuessText.setText("You have " + (theGuessAmount-1-lineNumber) + " guesses left!");

        RectangleClass theRectanges = guessRectanglesList.get(lineNumber);
        List<Circle> circlesInRectangleList = theRectanges.getListCircle();

        int i = 0;
        for(Circle circle : circlesInRectangleList){
            System.out.println("Feedbackarray[" + i + "]" + feedbackArray[i]);
            if(feedbackArray[i].equals("+")){
                circle.setFill(Color.WHITE);
            } else if(feedbackArray[i].equals("-")){
                circle.setFill(Color.GREY);
            } else{
                circle.setFill(Color.valueOf("#d7c0ae"));
            }
            i++;
        }

        isWinner = this.theGame.gameResult();

        if(isWinner){
            makeYourGuessText.setText("You Have Won");
        }else if((!isWinner) && (theGuessAmount-1 == lineNumber)){
            makeYourGuessText.setText("You've Used All Attempts");
            return;
        }

        userGuessClick = new ArrayList<String>();
        System.out.println("onCheckButtonClick works");
        System.out.println(guessValue);
        System.out.println("Line number: " + lineNumber + " GuessAmount: " + theGuessAmount);
        System.out.println("Printing secret sequence again" + Arrays.toString(secretSequence));
    }
    @FXML
    protected void onCircleClick(MouseEvent mouseEvent) {
        if(isWinner){
            makeYourGuessText.setText("Game is Over");
            return;
        } else if((!isWinner) && (theGuessAmount-1 == lineNumber)){
            makeYourGuessText.setText("You have Lost, Game is Over");
            return;
        }
        //user clicks check button before continuing
        if(isCheck == true){
            makeYourGuessText.setText("Check Your Guess");
            return;
        }

        //get mouse event on circle
        Circle circle = (Circle) mouseEvent.getSource();

        //get id of each circle clicked
        String id = circle.getId();
        userGuessClick.add(id);

        //count number of clicks
//        int rowIdx = clickCount%4; //when only 4 cells in a row
        int rowIdx = clickCount%cellsInOneRow;

        System.out.println("Id: " + id);
        System.out.println("CellIdx: " + cellIdx + " RowId: " + rowIdx);

        CircleRows row = this.circleCells.getCircleCell(cellIdx);
        //list of 4 circles
        List<Circle> circlesList = row.getCircleRowsList();

        Circle theCircle = circlesList.get(rowIdx);
        theCircle.setId(id);
        theCircle.setFill(circle.getFill());

        if((rowIdx == 3) && (cellsInOneRow == 4)){
            drawCheckButton();
            isCheck = true;
            cellIdx++;
        } else if((rowIdx == 4) && (cellsInOneRow == 5)){
            drawCheckButton();
            isCheck = true;
            cellIdx++;
        } else if((rowIdx == 5) && (cellsInOneRow == 6)){
            drawCheckButton();
            isCheck = true;
            cellIdx++;
        }

        clickCount++;
    }
    @FXML
    protected void onRestartClick(MouseEvent mouseEvent){

        for(Rectangle rectangle : mainRectanglesList){
            rectangle.setVisible(false);
        }

        for(RectangleClass rectangleClassElement : guessRectanglesList){
            List<Circle> circleList = rectangleClassElement.getListCircle();
            for(Circle circle : circleList){
                circle.setVisible(false);
            }
        }

        for(Rectangle square : smallSquares){
            square.setVisible(false);
        }

        for(int row = 0; row < theGuessAmount; row++){
            CircleRows circleRowsToRestart = circleCells.getCircleCell(row);
            for(Circle circle : circleRowsToRestart.getCircleRowsList()){
                circle.setVisible(false);
            }
        }

        for(Circle coloredCircle : colorInGame.returnColoredCircleOptionsList()){
            coloredCircle.setVisible(false);
        }

        initParams();
        initialize();
    }
    @FXML
    protected void onHelpClick(MouseEvent mouseEvent){
        Group group = new Group();
        screen = new Rectangle(5, 70, 420, 630);

        screen.setStroke(Color.BLACK);
        screen.setFill(Color.valueOf("#eee3cb"));
        screen.setStyle("-fx-arc-width: 15; -fx-arc-height:15;");

        closeButton = new Button();

        String style = "-fx-background-color: #d7c0ae; -fx-background-radius: 5; -fx-border-color: #000000; " +
                "-fx-border-radius: 4;";

        Font fontButton = new Font("American Typewriter", 8.0);

        closeButton = new Button();
        closeButton.setText("CLOSE");
        closeButton.setFont(fontButton);
        closeButton.setStyle(style);
        closeButton.setLayoutX(360);
        closeButton.setLayoutY(32);
        closeButton.setPrefHeight(30.0);
        closeButton.setPrefWidth(65.0);

        closeButton.setOnMouseClicked(event -> onCloseClick(event));

        String wordStyle = "-fx-alignment: center;";

        Font font = new Font("American Typewriter", 23.0);
        Font fontTextArea = new Font("American Typewriter", 16.0);

        welcome = new Label();
        welcome.setText("Welcome to the Mastermind Game!");
        welcome.setStyle(wordStyle);
        welcome.setFont(font);
        welcome.setLayoutY(92);
        welcome.setLayoutX(24);

        textArea = new TextArea();
        textArea.setText("Instructions: \n\nComputer has generated secret code,\nand you have to guess it! " +
                "\n\nChoose colors, and understand the\npegs on the right. They are the clues\nto the secret sequence. " +
                "\n\nWhite peg means that one of your\ncolors is correct and at the right\nspot. " +
                "\n\nBlack peg means that you have \nguessed the color, but it is not in the\ncorrect spot." +
                "\n\nIf once peg remains uncolored, then\none of the colors you entered is not\na part of the " +
                "secret sequence.\n\nFollow the pegs and guess the secret\nsequence. \n\nGood Luck!");
        textArea.setFont(fontTextArea);
        //layoutX="26.0" layoutY="149.0" prefHeight="528.0" prefWidth="383.0"
        textArea.setLayoutX(26);
        textArea.setLayoutY(149);
        textArea.setPrefHeight(505);
        textArea.setPrefWidth(383);
        textArea.setEditable(false);

        group.getChildren().add(screen);
        group.getChildren().add(welcome);
        group.getChildren().add(textArea);
        group.getChildren().add(closeButton);
        apMain.getChildren().add(group);
    }
    @FXML
    protected void onCloseClick(MouseEvent mouseEvent){
        screen.setVisible(false);
        closeButton.setVisible(false);
        welcome.setVisible(false);
        textArea.setVisible(false);
    }
    protected void drawColoredOptions(){
        Group group = new Group();

        int numOfColorChoice = theLevel;

        int startX = 393;
        int startY = 133;

        ColorOptions theColorOptions = new ColorOptions();

        colorInGame = new AmountColorsInGame();

        for(int color = 0; color < numOfColorChoice; color++){
            double y = startY + color*43;

            Circle circle = new Circle(startX, y, 18.f);
            circle.setOnMouseClicked(event -> onCircleClick(event));
            circle.setId(color+1 + "");

            circle.setStroke(Color.BLACK);
            circle.setFill(Color.valueOf(theColorOptions.theColorFromList(color)));

            colorInGame.setColoredCircleClicked(circle);

            group.getChildren().add(circle);
        }
        apMain.getChildren().add(group);
    }

    protected void drawCircles() {
        Group group = new Group();
        int startX = 0;
        int startY = 140;

        if(cellsInOneRow == 4){
            startX = 85;
        } else if(cellsInOneRow == 5){
            startX = 67;
        } else if(cellsInOneRow == 6){
            startX = 51;
        }

        circleCells = new CircleCells();
        for(int row = 0; row < theGuessAmount; row++){
            double y = startY + row*48;
            circleRows = new CircleRows();
            for(int cell = 0; cell < cellsInOneRow; cell++){
                double x = startX + cell*38;
                Circle circle = new Circle(x, y, 16.f);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.valueOf("#d7c0ae"));
                circleRows.setCircleRow(circle);
                group.getChildren().add(circle);
            }
            circleCells.setCircleCell(circleRows);
        }
        apMain.getChildren().add(group);
    }

    protected void drawSquaresAndSmallCircles(){
        //<Rectangle arcHeight="5.0" arcWidth="5.0" fill="#eee3cb" height="43.0" layoutX="293.0" layoutY="119.0" stroke="BLACK" strokeType="INSIDE" width="43.0" />
        Group group = new Group();
        int startX = 290;
        int startY = 120;

        smallSquares = new ArrayList<Rectangle>();
        for(int row = 0; row < theGuessAmount; row++) {
            smallCircleList = new ArrayList<Circle>();

            double x = startX;
            double y = startY + row * 48;
            Rectangle rectangle = new Rectangle(x, y, 44.0, 44.0);
            rectangle.setFill(Color.valueOf("#eee3cb"));
            rectangle.setStroke(Color.BLACK);
            smallSquares.add(rectangle);
            group.getChildren().add(rectangle);

            if(theLevel == 8){
                for (int rowOneCircle = 0; rowOneCircle < 5; rowOneCircle++) {
                    double circleX = x + 12 + rowOneCircle * 20;
                    double circleY = y + 12;

                    if(rowOneCircle == 4){
                        circleX = x + 12 + 10;
                        circleY += 10;
                    } else if (rowOneCircle > 1) {
                        circleX = x + 12 + (rowOneCircle % 2) * 20;
                        circleY += 20;
                    }

                    Circle smallCircle = new Circle(circleX, circleY, 5.5);
                    smallCircle.setFill(Color.valueOf("#d7c0ae"));
                    smallCircle.setStroke(Color.BLACK);
                    smallCircleList.add(smallCircle);
                    group.getChildren().add(smallCircle);
                }
                guessRectanglesList.add(new RectangleClass(smallCircleList));
            }
            else {
                for (int rowOneCircle = 0; rowOneCircle < 4; rowOneCircle++) {
                    double circleX = x + 12 + rowOneCircle * 20;
                    double circleY = y + 12;
                    if (rowOneCircle > 1) {
                        circleX = x + 12 + (rowOneCircle % 2) * 20;
                        circleY += 20;
                    }

                    Circle smallCircle = new Circle(circleX, circleY, 8.0);
                    smallCircle.setFill(Color.valueOf("#d7c0ae"));
                    smallCircle.setStroke(Color.BLACK);
                    smallCircleList.add(smallCircle);
                    group.getChildren().add(smallCircle);
                }
                guessRectanglesList.add(new RectangleClass(smallCircleList));
            }
        }
        apMain.getChildren().add(group);
    }

    protected void drawMainRectangles(){
        mainRectanglesList = new ArrayList<Rectangle>();

        Group group = new Group();
        int startX = 20;
        int startY = 118;

        for(int row = theGuessAmount-1; row > -1; row--){
            double y = startY + row*48;
            Rectangle rectangle = new Rectangle(startX, y, 245, 44);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.valueOf("#eee3cb"));
            mainRectanglesList.add(rectangle);
            group.getChildren().add(rectangle);
        }
        apMain.getChildren().add(group);
    }

    protected void drawStageBarsBasedOnLevel(){
        Group group = new Group();

        int heightOfColorsBar = 0;

        if(theLevel == 5){
            heightOfColorsBar = 225;
        } else if (theLevel == 6) {
            heightOfColorsBar = 270;
        } else if (theLevel == 7) {
            heightOfColorsBar = 315;
        } else if (theLevel == 8) {
            heightOfColorsBar = 360;
        }

        barWithColorsOnRight = new Rectangle(370, 107, 48, heightOfColorsBar);
        barWithColorsOnRight.setStroke(Color.BLACK);
        barWithColorsOnRight.setFill(Color.valueOf("#967e76"));
        barWithColorsOnRight.setStyle("-fx-arc-width: 15; -fx-arc-height:15;");

        group.getChildren().add(barWithColorsOnRight);

        apMain.getChildren().add(group);
    }

    protected void drawLevelButtons(){
        levelButtonList = new ArrayList<Button>();
        Group group = new Group();

        String style = "-fx-background-color: #eee3cb; -fx-background-radius: 5; -fx-border-color: #000000; " +
                "-fx-border-radius: 4;";

        Font font = new Font("American Typewriter", 8.0);

        Button theButtonLevel;

        List<String> levelNames = new ArrayList<String>();
        levelNames.add("Novice");
        levelNames.add("Beginner");
        levelNames.add("Intermediate");
        levelNames.add("Expert");

        int startX = 28;

        for(int buttonNum = 0; buttonNum < 4; buttonNum++){
            int x = startX + buttonNum*84;
            theButtonLevel = new Button();
            theButtonLevel.setText(levelNames.get(buttonNum));
            theButtonLevel.setFont(font);
            theButtonLevel.setStyle(style);
            theButtonLevel.setLayoutX(x);
            theButtonLevel.setLayoutY(123);
            theButtonLevel.setPrefHeight(30.0);
            theButtonLevel.setPrefWidth(65.0);

            Button tempButton = theButtonLevel;

            if(levelNames.get(buttonNum) == "Novice"){
                theButtonLevel.setOnMouseClicked(event -> onNoviceLevelClick(event));
            } else if(levelNames.get(buttonNum) == "Beginner"){
                theButtonLevel.setOnMouseClicked(event -> onBeginnerLevelClick(event));
            } else if(levelNames.get(buttonNum) == "Intermediate"){
                theButtonLevel.setOnMouseClicked(event -> onIntermediateLevelClick(event));
            } else if(levelNames.get(buttonNum) == "Expert"){
                theButtonLevel.setOnMouseClicked(event -> onExpertLevelClick(event));
            }

            levelButtonList.add(theButtonLevel);
            group.getChildren().add(theButtonLevel);
        }

        apMain.getChildren().add(group);
    }

    protected void drawHelpButton(){
        Group group = new Group();

        String style = "-fx-background-color: #eee3cb; -fx-background-radius: 5; -fx-border-color: #000000; " +
                "-fx-border-radius: 4;";

        Font font = new Font("American Typewriter", 8.0);

        theHelpButton = new Button();
        theHelpButton.setText("HELP");
        theHelpButton.setFont(font);
        theHelpButton.setStyle(style);
        theHelpButton.setLayoutX(360);
        theHelpButton.setLayoutY(32);
        theHelpButton.setPrefHeight(30.0);
        theHelpButton.setPrefWidth(65.0);

        theHelpButton.setOnMouseClicked(event -> onHelpClick(event));

        group.getChildren().add(theHelpButton);
        apMain.getChildren().add(group);
    }

    protected void drawCheckButton(){
        Group group = new Group();

        theCheckButton = new Button();

        String style = "-fx-background-color: #eee3cb; -fx-background-radius: 5; -fx-border-color: #000000; " +
                "-fx-border-radius: 5;";

        Font font = new Font("American Typewriter", 8.0);

        theCheckButton.setText("CHECK");
        theCheckButton.setFont(font);
        theCheckButton.setStyle(style);
        theCheckButton.setLayoutX(360);
        theCheckButton.setLayoutY(630);
        theCheckButton.setPrefHeight(30.0);
        theCheckButton.setPrefWidth(65.0);

        theCheckButton.setOnMouseClicked(event -> onCheckButtonClick(event));

        theCheckButton.setVisible(true);

        group.getChildren().add(theCheckButton);
        apMain.getChildren().add(group);
    }

    protected void drawRestartButton(){
        Group group = new Group();

        theRestartButton = new Button();

        String style = "-fx-background-color: #eee3cb; -fx-background-radius: 5; -fx-border-color: #000000; " +
                "-fx-border-radius: 5;";
        Font font = new Font("American Typewriter", 8.0);

        theRestartButton.setText("RESTART");
        theRestartButton.setFont(font);
        theRestartButton.setStyle(style);
        theRestartButton.setLayoutX(360);
        theRestartButton.setLayoutY(670);
        theRestartButton.setPrefHeight(30.0);
        theRestartButton.setPrefWidth(65.0);

        theRestartButton.setOnMouseClicked(event -> onRestartClick(event));

        group.getChildren().add(theRestartButton);
        apMain.getChildren().add(group);
    }
}