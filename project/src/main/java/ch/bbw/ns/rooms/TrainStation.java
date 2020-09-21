package ch.bbw.ns.rooms;

import ch.bbw.ns.Manager;
import ch.bbw.ns.items.Item;

public class TrainStation extends Room {

    public final static TrainStation INSTANCE = new TrainStation();

    public TrainStation(){
        name = "train station";
    }

    @Override
    public void use(Manager manager, Item i) {
            manager.updateStory();
            manager.setCurrentRoom(Veranda.INSTANCE);
    }
}
