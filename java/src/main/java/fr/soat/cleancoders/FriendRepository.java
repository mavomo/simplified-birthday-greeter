package fr.soat.cleancoders;

import fr.soat.cleancoders.highlevel.BirthdayGreeter;

import java.time.MonthDay;
import java.util.List;

public interface FriendRepository {

    List<BirthdayGreeter.Friend> findFriendsBornOn(MonthDay today);
}
