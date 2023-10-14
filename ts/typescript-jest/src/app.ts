import { Board } from './Board'
import { CanRoll } from './CanRoll'

import { UserInputReader } from './UserInputReader'

export async function play(board: Board, canRoll: CanRoll, reader: UserInputReader): Promise<void> {
  do {
    console.log(`Pulsa enter para tirar el dado`)
    await reader.askUserToRollDice()
    board.rollDice(canRoll)
    console.log(`El token está en la posición ${board.getTokenPosition()}`)
  } while (!board.hasWinner())
  reader.finish()
  return Promise.resolve()
}
