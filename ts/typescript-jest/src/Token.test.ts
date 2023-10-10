import { Token } from './Token';

describe("Token", () => {
  it("should should start at square one", () => {
    const token = new Token();
    expect(token.getPosition()).toBe(1);
  })
})