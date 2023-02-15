import Category from "./Category"

export default interface Room{
    id: number,
    category : Category,
    number: any,
    price: number,
    available: number
}