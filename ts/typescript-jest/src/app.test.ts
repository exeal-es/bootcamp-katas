import { play } from './app'
import { Board } from './Board'
import { RandomDice } from './RandomDice'
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
    const board = new Board(token)
    const dice = new RandomDice(1, 6)
    const reader = new FakeUserInputReader()

    await play(board, dice, reader)
    expect(board.hasWinner()).toBe(true)
    done()
  })
})
