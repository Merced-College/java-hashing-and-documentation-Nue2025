/**
 * SongRecord.java
 * @author Nue Lopez
 * @since 4/15/2025
 * CPSC-39
 * Hasing and Documentation: This file is to write documentation for a program that
 * uses a HashMap to store song records. It includes methods to load songs from a CSV file,
 * retrieve songs by ID, and display a GUI for searching songs. The program also includes
 * a main method to demonstrate its functionality if you aren't using the GUI.
 * In this file, it is recording the songs and putting them together.
 */

//package hashingAndDocumentation;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

/**
 * This class represents a song record with all information in the CSV file. 
 * It contains instance variables, constructors (listed later), getters, setters,
 * toString methods, comparison methods using .compareTo, and a hashCode return method.
 */
 public class SongRecord {
    // Instance variables
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

    /**
     * Default constructor with no parameters.
     * It lists all the instance variables and sets them to default values, 0 for integers and
     * 0.0 for doubles. 
     * Artists are set to Unknown Artist.
     * The Song Name is set to Unknown Title.
     */
    // Default constructor
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }

    /**
     * Constructor that takes a CSV string and parses it.
     * @param data The CSV string containing the String class song record data. It is stored in each line and must be separated
     * data will be helpful in splitting the values.
     * By using the String class, it will be able to split the values and store them in the instance variables.
     */
    public SongRecord(String data) {
        String[] fields = data.split(","); // Assuming comma-separated values
        
    	//fields = data.split(",");//means no quotes in the record
    	
    	/*System.out.println("fields length " + fields.length);
    	for(int i = 0; i < fields.length; i++) {
        	System.out.println("fields " + i + " = " + fields[i]);
        }*/
    	this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";"));
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
        
    }

    /**
     * Getters and setters for each field.
     * @return valence will return the valence of the song.
     * @return year will return the year of the song.
     * @return acousticness will return the acousticness of the song.
     * @return artists will return the artists of the song.
     * @return danceability will return the danceability of the song.
     * @return durationMs will return the duration of the song in milliseconds.
     * @return energy will return the energy of the song.  
     * @return explicit will return the explicit value of the song.
     * @return id will return the id of the song.
     * @return instrumentalness will return the instrumentalness of the song.
     * @return key will return the key of the song.
     * @return liveness will return the liveness of the song.
     * @return loudness will return the loudness of the song.
     * @return mode will return the mode of the song.
     * @return name will return the name of the song.
     * @return popularity will return the popularity of the song.
     * @return releaseDate will return the release date of the song.
     * @return speechiness will return the speechiness of the song.
     * @return tempo will return the tempo of the song.
     * All the getters and setters will return the values of the instance variables.
     */
    public double getValence() { return valence; }
    public void setValence(double valence) { this.valence = valence; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getAcousticness() { return acousticness; }
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }

    public List<String> getArtists() { return artists; }
    public void setArtists(List<String> artists) { this.artists = artists; }

    public double getDanceability() { return danceability; }
    public void setDanceability(double danceability) { this.danceability = danceability; }

    public int getDurationMs() { return durationMs; }
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }

    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    public int getExplicit() { return explicit; }
    public void setExplicit(int explicit) { this.explicit = explicit; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getInstrumentalness() { return instrumentalness; }
    public void setInstrumentalness(double instrumentalness) { this.instrumentalness = instrumentalness; }

    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    public double getLiveness() { return liveness; }
    public void setLiveness(double liveness) { this.liveness = liveness; }

    public double getLoudness() { return loudness; }
    public void setLoudness(double loudness) { this.loudness = loudness; }

    public int getMode() { return mode; }
    public void setMode(int mode) { this.mode = mode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public double getSpeechiness() { return speechiness; }
    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

    public double getTempo() { return tempo; }
    public void setTempo(double tempo) { this.tempo = tempo; }


    /**
     * toString method to return a string representation of the object.
     * @return Returns a String method of each file from all the instance variables.
     */
    @Override
    public String toString() {
        return "SongRecord{" +
                "valence=" + valence +
                ", year=" + year +
                ", acousticness=" + acousticness +
                ", artists=" + artists +
                ", danceability=" + danceability +
                ", durationMs=" + durationMs +
                ", energy=" + energy +
                ", explicit=" + explicit +
                ", id='" + id + '\'' +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                '}';
    }

    /**
     * equals method to compare two SongRecord objects.
     * @param o The object to compare with.
     * @return Returns true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRecord that = (SongRecord) o;
        return Double.compare(that.valence, valence) == 0 &&
                year == that.year &&
                Double.compare(that.acousticness, acousticness) == 0 &&
                Objects.equals(artists, that.artists) &&
                Double.compare(that.danceability, danceability) == 0 &&
                durationMs == that.durationMs &&
                Double.compare(that.energy, energy) == 0 &&
                explicit == that.explicit &&
                Objects.equals(id, that.id) &&
                Double.compare(that.instrumentalness, instrumentalness) == 0 &&
                key == that.key &&
                Double.compare(that.liveness, liveness) == 0 &&
                Double.compare(that.loudness, loudness) == 0 &&
                mode == that.mode &&
                Objects.equals(name, that.name) &&
                popularity == that.popularity &&
                releaseDate == that.releaseDate &&
                Double.compare(that.speechiness, speechiness) == 0 &&
                Double.compare(that.tempo, tempo) == 0;
    }

    /**
     * hashCode() method is to return the hash code of the object.
     * It is used to generate a unique hash code for the object based on its fields.
     * @return Returns the hash code of the object as an integer.
     */
    @Override
    public int hashCode() {
        return Objects.hash(valence, year, acousticness, artists, danceability, durationMs, energy, explicit, id,
                instrumentalness, key, liveness, loudness, mode, name, popularity, releaseDate, speechiness, tempo);
    }
}