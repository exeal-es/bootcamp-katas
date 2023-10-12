import { Board } from './Board'
import { Dice } from './Dice'
import { Snake } from './Snake'
import { Token } from './Token'

describe('Board', () => {
  it('should return token to position 2 when token arrives at position 12 and there is a snake connecting 12 and 2', () => {
    const token = new Token(10)
    const dice = new Dice()
    const board = new Board(token, dice)

    const rollSpy = jest.spyOn(dice, 'roll')
    rollSpy.mockReturnValue(2)

    board.moveToken()
    expect(token.getPosition()).toBe(2)
  })

  it("should allow to add snakes", () => {
    const token = new Token()
    const dice = new Dice()
    const board = new Board(token, dice)
    const snake = new Snake(12, 2)

    board.add(snake)
    expect(board.hasSnake(snake)).toBe(true)
  })
})
