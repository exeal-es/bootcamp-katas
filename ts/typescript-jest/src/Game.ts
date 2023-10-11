import { Dice } from "./Dice";
import { Token } from "./Token";

export class Game {

    token:Token;
    dice:Dice;

    constructor(token:Token, dice:Dice){
        this.token = token;
        this.dice = dice;
    }

    play(){
        
        this.token.move(this.dice.roll());
        
    }

}