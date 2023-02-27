import Feature from "./Feature";
import Room from "./Room";
import User from "./User";

export default interface BookRoom {
    room: Room;
    user: User;
    features: Feature[];
    year: number;
    month: number;
    dayOfMonth: number
}