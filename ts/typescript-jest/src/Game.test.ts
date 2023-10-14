import { CanRoll } from './CanRoll'
import { FakeDice } from './FakeDice'
import { Game } from './Game'
import { Token } from './Token'

class IncrementalDiceResult implements CanRoll {
  private currentResult: number = 1

  public roll(): number {
    const result = this.currentResult;
    this.currentResult++;
    return result;
  }
}

class DecrementalDiceResult implements CanRoll {
  private currentResult: number = 6

  public roll(): number {
    const result = this.currentResult;
    this.currentResult--;
    return result;
  }
}

describe("Game", () => {
  it("should not start when players get same result at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game(token1, token2)
    const dice = new FakeDice(1)

    const board = game.start(dice)

    expect(board).toBeUndefined()
  })


  it("should start with player 1 when gets the highest number at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game(token1, token2)
    const dice = new DecrementalDiceResult()

    const board = game.start(dice)
    board.rollDice(new FakeDice(1))

    expect(token1.getPosition()).toBe(2)
    expect(token2.getPosition()).toBe(1)
  })

  it("should start with player 2 when gets the highest number at game start", () => {
    const token1 = new Token(1)
    const token2 = new Token(1)
    const game = new Game(token1, token2)
    const dice = new IncrementalDiceResult()

    const board = game.start(dice)
    board.rollDice(new FakeDice(1))

    expect(token1.getPosition()).toBe(1)
    expect(token2.getPosition()).toBe(2)
  })
})