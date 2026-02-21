public class SingleRoomChoice implements RoomChoice{
    public boolean isSameType(int roomType){
        return roomType == LegacyRoomTypes.SINGLE;
    }
    public Money getBase(){
        return new Money(14000.0);
    }
}
