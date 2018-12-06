package fr.soat.cleancoders;

import fr.soat.cleancoders.details.EmailSender;
import fr.soat.cleancoders.highlevel.Friend;
import fr.soat.cleancoders.highlevel.MessageSender;
import fr.soat.cleancoders.details.SmsSender;
import fr.soat.cleancoders.highlevel.BirthdayGreeter;
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
import static org.mockito.BDDMockito.*;
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

    private final MessageSender emailSender = new EmailSender();
    private MessageSender smsSender = new SmsSender();

    @Before
    public void setUp() {
        System.setOut(printStream);
    }

    @Test
    public void send_a_greeting_email_to_the_friend_born_today() {
        Friend aFriend = FriendBuilder.aFriend().build();
        given(friendRepository.findFriendsBornOn(now()))
                .willReturn(singletonList(aFriend));


        birthdayGreeter.sendGreetings(emailSender);

        final String content = "To:" + aFriend.getEmailAdress() + ", Subject: Happy birthday!, Message: Happy birthday, dear " + aFriend.getName() + "!";
        then(printStream).should().print(content);
    }

    @Test
    public void send_a_greeting_sms_to_the_friend_born_today() {
        Friend aFriend = FriendBuilder.aFriend().build();
        given(friendRepository.findFriendsBornOn(now()))
                .willReturn(singletonList(aFriend));


        birthdayGreeter.sendGreetings(smsSender);

        final String content = "To:" + aFriend.getPhoneNumber() + ", Happy birthday, my dear " + aFriend.getName() + "!";
        then(printStream).should().print(content);
    }

    @Test
    public void not_send_any_greeting_email_when_its_nobody_s_birthday() {
        willReturn(EMPTY_LIST)
                .given(friendRepository).findFriendsBornOn(now());

        birthdayGreeter.sendGreetings(emailSender);

        then(printStream).should(never()).print(anyString());
    }

}
