public class TripleRoomChoice implements RoomChoice{
    public boolean isSameType(int roomType){
        return roomType == LegacyRoomTypes.TRIPLE;
    }
    public Money getBase(){
        return new Money(12000.0);
    }
}
