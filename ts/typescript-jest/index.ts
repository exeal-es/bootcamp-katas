import { Board } from './src/Board';
import { ConsoleUserInputReader } from './src/ConsoleUserInputReader';
import { Dice } from './src/Dice';
import { Game } from './src/Game';
import { Token } from './src/Token';
import { play } from './src/app';

import * as readline from 'readline'

const token = new Token()
const dice = new Dice()
const board = new Board(token, dice)
const game = new Game(board)
const reader = new ConsoleUserInputReader(readline.createInterface({
  input: process.stdin,
  output: process.stdout
}))

play(game, reader).then(() => {
  console.log(`Has ganado!`)
});