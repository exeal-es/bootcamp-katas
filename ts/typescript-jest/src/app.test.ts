import { play } from './app'
import { Board } from './Board'
import { Dice } from './Dice'
import { Game } from './Game'
import { Token } from './Token'
import { UserInputReader } from './UserInputReader'

class FakeUserInputReader implements UserInputReader {
  public askUserToRollDice(): Promise<void> {
    return Promise.resolve()
  }

  public finish(): void { return }
}

describe('App', () => {
  test('should handle an entire game', async (done) => {
    const token = new Token()
    const dice = new Dice()
    const board = new Board(token, dice)
    const game = new Game(board)
    const reader = new FakeUserInputReader()

    await play(game, reader)
    expect(game.hasEnded()).toBe(true)
    done()
  })
})
