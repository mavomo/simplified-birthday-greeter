package fr.soat.cleancoders;

import fr.soat.cleancoders.highlevel.Friend;

import java.time.MonthDay;
import java.util.List;

public interface FriendRepository {

    List<Friend> findFriendsBornOn(MonthDay today);
}
