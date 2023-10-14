import { Board } from './Board'
import { FakeDice } from './FakeDice'
import { Game } from './Game'
import { Token } from './Token'

describe('Game', () => {
  it('should be in the position 5 when the dice roll 4', () => {
    const token = new Token()
    const board = new Board(token)
    const game = new Game(board)

    game.throwDice(new FakeDice(4))
    expect(token.getPosition()).toBe(5)
  })
})
