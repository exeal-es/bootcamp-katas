import { Token } from './Token';

describe("Token", () => {
  it("should should start at square one", () => {
    const token = new Token();
    expect(token.getPosition()).toBe(1);
  })

  it("should be on position 4 after moving 3 spaces", () => {
    const token = new Token();
    token.move(3);
    expect(token.getPosition()).toBe(4);
  })

  it("should be on position 8 after moving 3 and then 4 spaces", () => {
    const token = new Token();
    token.move(3);
    token.move(4);
    expect(token.getPosition()).toBe(8);
  })
})