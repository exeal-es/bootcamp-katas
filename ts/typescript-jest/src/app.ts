import { Board } from './Board'
import { RandomDice } from './RandomDice'

import { UserInputReader } from './UserInputReader'

export async function play(board: Board, reader: UserInputReader): Promise<void> {
  do {
    console.log(`Pulsa enter para tirar el dado`)
    await reader.askUserToRollDice()
    const dice = new RandomDice(1, 6)
    board.rollDice(dice)
    console.log(`El token está en la posición ${board.getTokenPosition()}`)
  } while (!board.hasWinner())
  reader.finish()
  return Promise.resolve()
}
