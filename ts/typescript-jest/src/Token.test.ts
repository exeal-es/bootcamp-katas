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

  it("should be on position 100 after moving 3 when token is on position 97", () => {
    const token = new Token(97);

    token.move(3);
    expect(token.getPosition()).toBe(100);
  })

  it("should be on position 97 after moving 4 when token is on position 97", () =>{

    const token = new Token(97);

    token.move(4);
    expect(token.getPosition()).toBe(97);
 
  })
  
      it("should be a winner when the token is on position 100", () => {
        const token = new Token(100);

        expect(token.hasWon()).toBe(true);
    })
})