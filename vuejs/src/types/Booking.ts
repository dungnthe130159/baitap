import Room from "./Room";
import User from "./User";

export default interface Booking {
    id: number,
    user: User,
    room: Room,
    dateFrom: Date,
    dateTo: Date,
    totalPrice: number,
}