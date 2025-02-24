import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocialNetworkShould {
    @Mock
    Console console;

    @ParameterizedTest
    @CsvSource({
            "Alice -> I love the weather today, I love the weather today",
            "Alice -> Damn! We lost!, Damn! We lost!"
    })
    void show_a_message_in_timeline_that_was_previously_sent(String input, String expectedOutput) {
        when(console.readLine()).thenReturn(input, "Alice");

        new SocialNetwork(console).start();

        verify(console).printLine(expectedOutput);
    }
}
