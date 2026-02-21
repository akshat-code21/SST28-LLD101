public class DoubleRoomChoice implements RoomChoice{
    public boolean isSameType(int roomType){
        return roomType == LegacyRoomTypes.DOUBLE;
    }
    public Money getBase(){
        return new Money(15000.0);
    }
}
