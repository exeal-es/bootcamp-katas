import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocialNetworkShould {

    @Mock
    Console console;

    @Test
    void show_a_message_in_timeline_that_was_previously_sent() {
        when(console.readLine()).thenReturn("Alice -> I love the weather today", "Alice");

        new SocialNetwork(console).start();

        verify(console).printLine("I love the weather today");
    }
}
