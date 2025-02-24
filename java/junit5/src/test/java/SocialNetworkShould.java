import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SocialNetworkShould {

    @Mock
    Console console;

    @Test
    void show_a_message_in_timeline_that_was_previously_sent() {
        Mockito.when(console.readLine()).thenReturn("Alice -> I love the weather today", "Alice");

        new SocialNetwork(console).start();

        Mockito.verify(console).printLine("I love the weather today");
    }
}
