package main.ReservationSub.command;

import main.dbsub.DBFacadeImpl;
import main.dbsub.DBService;
import main.model.FRReservationModel;

/**
 * Created by Gize on 4/22/2017.
 */
public class DeleteReservationCommand implements ReservationCommands {
    DBService dbService = new DBFacadeImpl();
    FRReservationModel obj;

    public DeleteReservationCommand(FRReservationModel obj) {
        this.obj = obj;
    }

    @Override
    public boolean executeReservationCommands() {

        return dbService.deleteReservationById(obj.getCode()) != 0 ? true : false;

    }
}
