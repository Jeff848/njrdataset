/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import NPC.Aela;
import commands.Game;
import commands.GameState;
import java.util.List;
import rooms.*;

/**
 *
 * @author Irakiza Krak
 */
public class TransformBackSpellBook extends AbstractItemMovable{

    private String spell;
    
    public TransformBackSpellBook (){
        super("Book", "Spell book that permits to transform back members of the Companions \n"
                + "Who are in form of Werewolves, even dead", "bo");
        this.spell = "unlock";
    }
    
    
    
    public String getSpell(){
        return this.spell;
    }
    
    public void setSpell(String spellSet){
        this.spell= spellSet;
    }
    @Override
    public List<Item> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GameState use(Game game) {
       
       if(game.getCurrentRoom() instanceof LockedRoom ||
                game.getCurrentRoom() instanceof MagicRoom){
                game.getCurrentRoom().activate(game, game.getCurrentRoom().getSecretExit());
                System.out.println("Aela is back to normal");
                game.getCurrentRoom().addNpc(new Aela("Blabla","Blabla"));
                System.out.println("The way to "+game.getCurrentRoom().getSecretExit().getName()+ " has been activated look around");
                game.getCurrentRoom().removeItem(this);
                game.getBackPack().remove(this.getName());
       }else{
           System.out.println("You can't use this object here");
       }
       
       return game.getGameState();
        
    }

    @Override
    public void addItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
