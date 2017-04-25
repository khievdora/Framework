package main.ReservationSub.command;

import main.dbsub.ReservationImpl;
import main.model.FRReservationModel;

import java.util.Stack;

/**
 * Created by Gize on 4/22/2017.
 */
public class ReservationSubSystemOperations {
    private ReservationCommands currentCommand = null;
    private Stack<ReservationCommands> executedCommands = new Stack<>();

    public boolean addReservation(FRReservationModel res) {
        currentCommand = new SaveReservationCommand(res);
        if (currentCommand.executeReservationCommands()) {
            executedCommands.push(currentCommand);
            return true;
        }
        return false;
    }

    public boolean deleteReservationById(FRReservationModel res) {
        currentCommand = new DeleteReservationCommand(res);
        if (currentCommand.executeReservationCommands()) {
            executedCommands.push(currentCommand);
            return true;
        }
        return false;
    }

    public boolean editReservation(FRReservationModel res) {
        currentCommand = new EditReservationCommand(res);
        if (currentCommand.executeReservationCommands()) {
            executedCommands.push(currentCommand);
            return true;
        }
        return false;
    }
}
