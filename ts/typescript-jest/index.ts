import { Board } from './src/Board';
import { ConsoleUserInputReader } from './src/ConsoleUserInputReader';
import { Token } from './src/Token';
import { play } from './src/app';

import * as readline from 'readline';

const token = new Token()
const board = new Board(token)
const reader = new ConsoleUserInputReader(readline.createInterface({
  input: process.stdin,
  output: process.stdout
}))

play(board, reader).then(() => {
  console.log(`Has ganado!`)
});