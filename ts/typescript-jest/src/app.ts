import { Game } from './Game'

import { UserInputReader } from './UserInputReader'

export async function play(game: Game, reader: UserInputReader): Promise<void> {
  do {
    console.log(`Pulsa enter para tirar el dado`)
    await reader.askUserToRollDice()
    game.play()
    console.log(`El token está en la posición ${game.getTokenPosition()}`)
  } while (!game.hasEnded())
  reader.finish()
  return Promise.resolve()
}
