import java.util.HashMap;
import java.util.Set;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Definieer een uitgang in deze ruimte. 
     * @param direction. De richting van de uitgang.
     * @param neighbour. De ruimte in die richting.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Retourneer een string met daarin de uitgangen van de ruimte,
     * bijvoorbeeld "Exits: north west" 
     * @return Een omschrijving van de aanwezige uitgangen in de
     * ruimte.
     */
    public String getExitString()
    {
       String returnString = "Exits:";
       Set<String> keys = exits.keySet();
       for(String exit : keys) {
            returnString += " " + exit;
       }
       return returnString;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Retourneer een lange omschrijving van deze ruimte, van de vormen:
     *     You are in the kitchen.
     *     Exits: north west
     * @return Een omschrijving van de ruimte en haar uitgangen.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
}