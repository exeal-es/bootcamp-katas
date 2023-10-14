import { Game } from './Game'
import { RandomDice } from './RandomDice'

import { UserInputReader } from './UserInputReader'

export async function play(game: Game, reader: UserInputReader): Promise<void> {
  do {
    console.log(`Pulsa enter para tirar el dado`)
    await reader.askUserToRollDice()
    const dice = new RandomDice(1, 6)
    game.rollDice(dice)
    console.log(`El token está en la posición ${game.getTokenPosition()}`)
  } while (!game.hasEnded())
  reader.finish()
  return Promise.resolve()
}
