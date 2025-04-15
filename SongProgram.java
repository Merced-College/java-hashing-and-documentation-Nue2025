/*
 * SongProgram.java
 * Nue Lopez
 * CPSC-39
 * 4/15/2025
 * Hasing and Documentation
 */

//package hashingAndDocumentation;//Comment this out if you do not need a package
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

public class SongProgram { // Main class for the program

    // HashMap to store SongRecords with the song's ID as the key
    private HashMap<String, SongRecord> songMap;

    public SongProgram() {  // Constructor of SongProgram() to make the HashMap.
        songMap = new HashMap<>(); //Initialize the HashMap with no parameters in the brackets.
    }

    // Method to load songs from a CSV file
    public void loadSongsFromCSV(String filePath) { //This is the name of our CSV file that the function will look for.
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) { //File reader is from our imports.
            String line;
            
            //read in first line and do nothing with it
            br.readLine();
            
            while ((line = br.readLine()) != null) { //While NOT null, it will read line by line of the file.
            	
            	//System.out.println(line);//for testing
                //Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) { //If there is an error reading the file, it will print the error.
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }

    // Method to retrieve a SongRecord by ID
    public SongRecord getSongById(String id) { //This method returns the song by ID when it gets brought in. This is a getter method.
        return songMap.get(id);
    }

    // Method to print all songs (for debugging or display purposes)
    public void printAllSongs() { //This has no parameter/argument, so it prints out songMap hashMap. 
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }
    
    // GUI method to search for a song by ID in an interactive way. 
    // This method creates a JFrame and adds components to it, only available through an IDE, not through GitHub/consoles.
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup"); //You have to create a frame.
        frame.setSize(400, 200); //It needs to have a size or else it won't exist.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:"); //Creates the button of Entering a song ID to the GUI.
        JTextField idField = new JTextField(20); //Creates the button of typing something for 20 characters.
        JButton searchButton = new JButton("Search"); //Creates the button of Search to the GUI.

        // Add label, text field, and button to panel from above. 
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button. Searches through the program to find the song.
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) { //If the song is NOT null, it will print out the song because it has been found in the CSV.
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found."); //This will print out when no song is found because it is null.
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true); //This sets the GUI to visible. Earlier it wasn't visible, only created.
    }


    // Main method to demonstrate functionality and open GUI
    public static void main2(String[] args) { 
        SongProgram program = new SongProgram(); // Create an instance of the program

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }

    // Main method to demonstrate functionality through the console/debugger.
    public static void main(String[] args) {
        SongProgram program = new SongProgram(); //program is an instance of SongProgram.

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path. In our case, it is data.csv, but in other cases it would be the file name of the songs.
        program.loadSongsFromCSV(filePath); //Doesn't do anything, but has it in the program.

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        //program.printAllSongs();
    }
}

