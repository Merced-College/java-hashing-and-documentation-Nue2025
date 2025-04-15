/**
 * SongProgram.java
 * @author Nue Lopez
 * @since 4/15/2025
 * CPSC-39
 * Hasing and Documentation: This program is to write documentation for a program that
 * uses a HashMap to store song records. It includes methods to load songs from a CSV file,
 * retrieve songs by ID, and display a GUI for searching songs. The program also includes
 * a main method to demonstrate its functionality if you aren't using the GUI.
 */

//package hashingAndDocumentation; //Comment this out if you do not need a package
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**
 * SongProgram class to manage song records.
 * It uses a HashMap called songMap to store song records with their IDs as keys.
 * It contains multiple methods to load songs from a CSV file such as loadSongsFromCSV.
 * It has a getter and print methods for retrieving and displaying songs.
 * There is a GUI for searching songs by ID called openSearchGui.
 */
//package hashingAndDocumentation;//comment this out if you do not need a package
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.HashMap;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.HashMap;


public class SongProgram {
    // HashMap to store SongRecords with the song's ID as the key
    private HashMap<String, SongRecord> songMap;

    // Constructor
    public SongProgram() {
        songMap = new HashMap<>();
    }

    /**
     * This method loads songs from a CSV file into the songMap hash.
    * Each line in the CSV file represents a song record.
    * The class/method will be recording all the songs and holding them.
    * @param filePath The path to the CSV file containing song records.
    */
    // Method to load songs from a CSV file
    public void loadSongsFromCSV(String filePath) {
    /**
     * This method will load songs from a CSV file and read the lines in order. 
     * It will record lines until it is completed.
     * This will throw an exception if there is an error reading the CSV file.
    */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            //read in first line and do nothing with it
            br.readLine();
            
            while ((line = br.readLine()) != null) {
            
            //System.out.println(line);//for testing
                // Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    /**
     * Method to retrieve a SongRecord by ID.
    * @param id will be the ID of the song from the user.
    * @return The SongRecord will return the id of the song from songMap.
    */
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

    /**
     * Method to print all songs (for debugging or display purposes)
     * There is no return values since it is not static and it is void.
    */
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }
    
    /**
    * GUI method to search for a song by ID
    * This creates a manin frame, input buttons, several fields for the different elements, displays it to the user,
    * and allows the user to search for a song by ID.
    * 
    * Creates several shapes and objects to display on the screen using the JFrame, JPanel, JLabel, JTextField, JButton, and JTextArea.
    * This is not visible at the moment, but it will be when the program is run.
    */
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add label, text field, and button to panel
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

/**
* Main method to demonstrate functionality and open GUI mainframe.
* This is the main method that will run the program, taking from SongProgram class.
* It will load songs from a CSV file, open the GUI, and allow the user to search for songs by ID.
* @param args Command line arguments (not used)
*/
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }


    /**
     * Main method to demonstrate functionality without GUI.
    * program is an instance of SongProgram.
    * @param args
    * It will load the songs from the file and search for songs using the testID.
    * If any song(s) are found, it will print them to the console.
    * If no song(s) are found, it will print a message saying that the song was not found.
    */
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        program.printAllSongs();
    }
}