package main.ReservationSub.command;

import main.dbsub.DBFacadeImpl;
import main.dbsub.DBService;
import main.model.FRReservationModel;

/**
 * Created by Gize on 4/22/2017.
 */
public class SaveReservationCommand implements ReservationCommands {
    DBService dbService = new DBFacadeImpl();
    FRReservationModel obj;

    public SaveReservationCommand(FRReservationModel reservation) {
        this.obj=reservation;
    }

    @Override
    public boolean executeReservationCommands() {
      return  dbService.saveReservation(obj) != 0 ? true : false;
    }
}
