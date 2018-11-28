package fr.soat.cleancoders;

import java.time.MonthDay;
import java.util.List;

public interface FriendRepository {

    List<Friend> findFriendsBornOn(MonthDay today);
}
