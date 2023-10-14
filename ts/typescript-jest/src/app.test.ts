import { play } from './app'
import { Board } from './Board'
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
    const reader = new FakeUserInputReader()

    await play(board, reader)
    expect(board.hasWinner()).toBe(true)
    done()
  })
})
