import { Dice } from './Dice';
import { Game } from "./Game";
import { Token } from "./Token";


const token = new Token();
const dice = new Dice();
const game = new Game(token, dice);

for (let i = 0; i < 10; i++) {
    game.play();

    console.log(token.getPosition());

}