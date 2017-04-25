package main.dbsub;

import main.model.FRProductTypeModel;

import java.util.List;

/**
 * Created by Dora on 4/22/2017.
 */
public interface IRoomType {

    public int saveRoomType(FRProductTypeModel roomType);
    public int updateRoomType(FRProductTypeModel roomType);
    public int deleteRoomType(FRProductTypeModel roomType);
    public int deleteRoomTypeById(int roomTypeId);
    public FRProductTypeModel getRoomTypeById(int roomTypeId);
    public List<FRProductTypeModel> getAllRoomType();


}
