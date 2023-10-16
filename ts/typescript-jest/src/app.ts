import { Board } from './Board'
import { Dice } from './CanRoll'

import { UserInputReader } from './UserInputReader'

export async function play(board: Board, canRoll: Dice, reader: UserInputReader): Promise<void> {
  do {
    console.log(`Pulsa enter para tirar el dado`)
    await reader.askUserToRollDice()
    board.rollDice(canRoll)
    console.log(`El token está en la posición ${board.getTokenWithTurnPosition()}`)
  } while (!board.hasWinner())
  reader.finish()
  return Promise.resolve()
}
