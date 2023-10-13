import { Board } from './Board'
import { Dice } from './Dice'
import { Ladder } from './Ladder'
import { Snake } from './Snake'
import { Token } from './Token'

describe('Board', () => {
  it('should return token to position 2 when token arrives at position 12' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(10)
      const dice = new Dice()
      const board = new Board(token, dice)
      const snake = new Snake(12, 2)

      const rollSpy = jest.spyOn(dice, 'roll')
      rollSpy.mockReturnValue(2)

      board.place(snake)
      board.moveToken()
      expect(token.getPosition()).toBe(2)
    })

  it('should return token to position 3 when token arrives at position 15' +
    ' and there is a snake connecting 15 and 3', () => {

      const token = new Token(13)
      const dice = new Dice()
      const board = new Board(token, dice)
      const snake = new Snake(15, 3)

      const rollSpy = jest.spyOn(dice, 'roll')
      rollSpy.mockReturnValue(2)

      board.place(snake)
      board.moveToken()
      expect(token.getPosition()).toBe(3)
    })

  it('should not move token to position 12 when token arrives at position 2' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(1)
      const dice = new Dice()
      const board = new Board(token, dice)
      const snake = new Snake(12, 2)

      const rollSpy = jest.spyOn(dice, 'roll')
      rollSpy.mockReturnValue(1)

      board.place(snake)
      board.moveToken()
      expect(token.getPosition()).toBe(2)
    })

  it('should moves token to position 12 when token arrives at position 2' +
    ' and there is a ladder connecting 2 and 12', () => {

      const token = new Token(1)
      const dice = new Dice()
      const board = new Board(token, dice)
      const ladder = new Ladder(2, 12)

      const rollSpy = jest.spyOn(dice, 'roll')
      rollSpy.mockReturnValue(1)

      board.place(ladder)
      board.moveToken()
      expect(token.getPosition()).toBe(12)
    })

  it('should allow to place figures', () => {
    const token = new Token()
    const dice = new Dice()
    const board = new Board(token, dice)
    const snake = new Snake(12, 2)
    const ladder = new Ladder(3, 13)

    board.place(snake)
    board.place(ladder)
    expect(board.has(snake)).toBe(true)
    expect(board.has(ladder)).toBe(true)
  })
})
