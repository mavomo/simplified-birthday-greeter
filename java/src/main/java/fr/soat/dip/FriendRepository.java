package fr.soat.dip;

import java.time.MonthDay;
import java.util.List;

public interface FriendRepository {
    List<Friend> findFriendsBornOn(MonthDay today);
}
