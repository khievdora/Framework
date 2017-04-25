package main.dbsub;

import main.model.FRProductModel;

import java.util.List;

/**
 * Created by Dora on 4/22/2017.
 */
public interface IRoom {

    public int saveRoom(FRProductModel room);
    public int updateRoom(FRProductModel room);
    public int deleteRoom(FRProductModel room);
    public int deleteRoomById(int roomId);
    public FRProductModel getRoomById(int roomId);
    public List<FRProductModel> getAllRoom();

}
