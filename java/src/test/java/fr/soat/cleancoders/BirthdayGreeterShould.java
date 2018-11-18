package fr.soat.cleancoders;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.PrintStream;

import static java.time.MonthDay.now;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.singletonList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;

public class BirthdayGreeterShould {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private FriendRepository friendRepository;

    @Mock
    private PrintStream printStream;

    @InjectMocks
    private BirthdayGreeter birthdayGreeter;

    @Before
    public void setUp() {
        System.setOut(printStream);
    }

    @Test
    public void send_a_greeting_email_to_the_friend_born_today() {
        Friend aFriend = FriendBuilder.aFriend().build();
        given(friendRepository.findFriendsBornOn(now()))
                .willReturn(singletonList(aFriend));


        birthdayGreeter.sendGreetings();

        final String content = "To:" + aFriend.getContact() + ", Subject: Happy birthday!, Message: Happy birthday, dear " + aFriend.getName() + "!";
        then(printStream).should().print(content);
    }

    @Test
    public void not_send_any_greeting_email_when_its_nobody_s_birthday() {
        willReturn(EMPTY_LIST)
                .given(friendRepository).findFriendsBornOn(now());

        birthdayGreeter.sendGreetings();

        then(printStream).should(never()).print(anyString());
    }

}
