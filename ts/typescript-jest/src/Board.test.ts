import { Board } from './Board'
import { FakeDice } from './FakeDice'
import { Ladder } from './Ladder'
import { Snake } from './Snake'
import { Token } from './Token'

describe('Board', () => {
  it('should return token to position 2 when token arrives at position 12' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(10)
      const board = new Board(token)
      const snake = new Snake(12, 2)

      board.place(snake)
      board.rollDice(new FakeDice(2))
      expect(token.getPosition()).toBe(2)
    })

  it('should return token to position 3 when token arrives at position 15' +
    ' and there is a snake connecting 15 and 3', () => {

      const token = new Token(13)
      const board = new Board(token)
      const snake = new Snake(15, 3)

      board.place(snake)
      board.rollDice(new FakeDice(2))
      expect(token.getPosition()).toBe(3)
    })

  it('should not move token to position 12 when token arrives at position 2' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(1)
      const board = new Board(token)
      const snake = new Snake(12, 2)

      board.place(snake)
      board.rollDice(new FakeDice(1))
      expect(token.getPosition()).toBe(2)
    })

  it('should moves token to position 12 when token arrives at position 2' +
    ' and there is a ladder connecting 2 and 12', () => {

      const token = new Token(1)
      const board = new Board(token)
      const ladder = new Ladder(2, 12)

      board.place(ladder)
      board.rollDice(new FakeDice(1))
      expect(token.getPosition()).toBe(12)
    })

  it('should not move token to position 12 when token arrives at position 12' +
    ' and there is a ladder connecting 2 and 12', () => {

      const token = new Token(11)
      const board = new Board(token)
      const ladder = new Ladder(2, 12)

      board.place(ladder)
      board.rollDice(new FakeDice(1))
      expect(token.getPosition()).toBe(12)
    })

  it('should allow to place figures', () => {
    const token = new Token()
    const board = new Board(token)
    const snake = new Snake(12, 2)
    const ladder = new Ladder(3, 13)

    board.place(snake)
    board.place(ladder)
    expect(board.has(snake)).toBe(true)
    expect(board.has(ladder)).toBe(true)
  })
})
