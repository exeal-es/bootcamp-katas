import { Board } from './Board'
import { Dice } from './Dice'
import { Token } from './Token'

describe('Board', () => {
  it('should return token to position 2 when token arrives at position 12 and there is a snake', () => {
    const token = new Token(10)
    const dice = new Dice()
    const board = new Board(token, dice)

    const rollSpy = jest.spyOn(dice, 'roll')
    rollSpy.mockReturnValue(2)

    board.moveToken()
    expect(token.getPosition()).toBe(2)
  })
})
